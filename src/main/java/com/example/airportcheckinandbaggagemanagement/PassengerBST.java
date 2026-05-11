package com.example.airportcheckinandbaggagemanagement;

public class PassengerBST {
    BSTNode root;

    // INSERT
    public BSTNode insert(BSTNode root, Passenger p) {
        if (root == null) return new BSTNode(p);

        if (p.ticketNumber < root.passenger.ticketNumber)
            root.left = insert(root.left, p);
        else
            root.right = insert(root.right, p);

        return root;
    }

    // SEARCH
    public Passenger search(BSTNode root, int ticketNumber) {
        if (root == null) return null;

        if (ticketNumber == root.passenger.ticketNumber)
            return root.passenger;

        if (ticketNumber < root.passenger.ticketNumber)
            return search(root.left, ticketNumber);
        else
            return search(root.right, ticketNumber);
    }

    // LIST ALL
    public String getAllPassengers(BSTNode root) {
        StringBuilder result = new StringBuilder();
        inorder(root, result);
        return result.toString();
    }

    private void inorder(BSTNode root, StringBuilder result) {
        if (root != null) {
            inorder(root.left, result);
            result.append(root.passenger).append("\n");
            inorder(root.right, result);
        }
    }
}
