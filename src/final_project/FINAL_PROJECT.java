/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package final_project;
import  GUI.Login;
import javax.swing.SwingUtilities;
/**
 *
 * @author Arber
 */
public class FINAL_PROJECT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Run the GUI on the Event Dispatch Thread (important for Swing)
        SwingUtilities.invokeLater(() -> {
            new Login();
        });
                }
    
}
