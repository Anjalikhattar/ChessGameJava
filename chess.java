import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chess {
    static JLabel[][] labels = new JLabel[8][8];
    static int selectedRow = -1, selectedCol = -1;
    static boolean isWhiteTurn = true;
    static JPanel board;

    static String[][] boardState = {
            {"♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"},
            {"♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟"},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙"},
            {"♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"}
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess Game");
        board = new JPanel(new GridLayout(8, 8));
        frame.setSize(600, 600);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JLabel label = new JLabel(boardState[i][j], SwingConstants.CENTER);
                label.setFont(new Font("Serif", Font.PLAIN, 36));
                label.setOpaque(true);
                label.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                final int row = i, col = j;
                label.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        handleClick(row, col);
                    }
                });
                labels[i][j] = label;
                board.add(label);
            }
        }

        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void handleClick(int row, int col) {
        String selectedPiece = boardState[row][col];
        if (selectedRow == -1 && !selectedPiece.equals("")) {
            if (isWhiteTurn && Character.isLowerCase(selectedPiece.charAt(0))) return;
            if (!isWhiteTurn && Character.isUpperCase(selectedPiece.charAt(0))) return;
            selectedRow = row;
            selectedCol = col;
            labels[row][col].setBackground(Color.YELLOW);
        } else if (selectedRow != -1) {
            if (isValidMove(selectedRow, selectedCol, row, col)) {
                String piece = boardState[selectedRow][selectedCol];
                if (boardState[row][col].equals("♚") || boardState[row][col].equals("♔")) {
                    JOptionPane.showMessageDialog(board, (isWhiteTurn ? "White" : "Black") + " wins!");
                    System.exit(0);
                }
                boardState[row][col] = piece;
                boardState[selectedRow][selectedCol] = "";
                labels[row][col].setText(piece);
                labels[selectedRow][selectedCol].setText("");
                labels[selectedRow][selectedCol].setBackground((selectedRow + selectedCol) % 2 == 0 ? Color.WHITE : Color.GRAY);
                isWhiteTurn = !isWhiteTurn;
            } else {
                labels[selectedRow][selectedCol].setBackground((selectedRow + selectedCol) % 2 == 0 ? Color.WHITE : Color.GRAY);
            }
            selectedRow = -1;
            selectedCol = -1;
        }
    }

    static boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromRow == toRow && fromCol == toCol) return false;
        String piece = boardState[fromRow][fromCol];
        String target = boardState[toRow][toCol];
        if (!target.equals("")) {
            if ((Character.isUpperCase(piece.charAt(0)) && Character.isUpperCase(target.charAt(0))) ||
                (Character.isLowerCase(piece.charAt(0)) && Character.isLowerCase(target.charAt(0)))) return false;
        }
        // Simplified validation: allow all moves for demonstration
        return true;
    }
}
