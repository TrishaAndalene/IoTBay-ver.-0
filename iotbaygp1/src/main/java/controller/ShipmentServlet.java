package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.DBConnector;
import dao.ShipmentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Shipment;

@WebServlet("/ShipmentServlet")
public class ShipmentServlet extends HttpServlet {
    private ShipmentDAO shipmentDAO;

    @Override
    public void init() throws ServletException {
        try {
            DBConnector dbConnector = new DBConnector();
            Connection conn = dbConnector.openConnection();
            shipmentDAO = new ShipmentDAO(conn);
        } catch (Exception e) {
            throw new ServletException("Failed to initialize ShipmentDAO", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action != null ? action : "list") {
                case "new":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteShipment(request, response);
                    break;
                default:
                    listShipments(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String shipmentIdStr = request.getParameter("shipmentId");
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String method = request.getParameter("shipmentMethod");
        Date date = Date.valueOf(request.getParameter("shipmentDate"));
        String address = request.getParameter("shipmentAddress");

        Shipment shipment = new Shipment();
        shipment.setOrderId(orderId);
        shipment.setShipmentMethod(method);
        shipment.setShipmentDate(date);
        shipment.setShipmentAddress(address);

        try {
            if (shipmentIdStr == null || shipmentIdStr.isEmpty()) {
                shipmentDAO.addShipment(shipment);
            } else {
                shipment.setShipmentId(Integer.parseInt(shipmentIdStr));
                shipmentDAO.updateShipment(shipment);
            }

            request.getSession().removeAttribute("orderId");
            response.sendRedirect("ShipmentServlet");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object rawOrderId = session.getAttribute("orderId");

        if (rawOrderId == null) {
            throw new ServletException("Missing orderId in session. Cannot create shipment.");
        }

        int orderId;
        try {
            orderId = rawOrderId instanceof Integer
                    ? (Integer) rawOrderId
                    : Integer.parseInt(rawOrderId.toString());
        } catch (Exception e) {
            throw new ServletException("Invalid orderId format in session", e);
        }

        Shipment shipment = new Shipment();
        shipment.setOrderId(orderId);
        request.setAttribute("shipment", shipment);
        request.getRequestDispatcher("/ShipmentForm.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int shipmentId = Integer.parseInt(request.getParameter("id"));
        Shipment shipment = shipmentDAO.getShipmentById(shipmentId);
        request.setAttribute("shipment", shipment);
        request.getRequestDispatcher("/ShipmentForm.jsp").forward(request, response);
    }

    private void deleteShipment(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int shipmentId = Integer.parseInt(request.getParameter("id"));
        shipmentDAO.deleteShipment(shipmentId);
        response.sendRedirect("ShipmentServlet");
    }

    private void listShipments(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Shipment> shipments = shipmentDAO.getAllShipments();
        request.setAttribute("shipmentList", shipments);
        request.getRequestDispatcher("/ShipmentList.jsp").forward(request, response);
    }
}
