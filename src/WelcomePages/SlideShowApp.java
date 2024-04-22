/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WelcomePages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlideShowApp extends JFrame{
private JPanel contentPane;
    private JLabel slideLabel;
    private Timer timer;
    private int currentSlideIndex;

    private String[] imagePaths = {
            "D:\\content\\HeroGymLastEdition\\src\\img\\login.jpg",
            "D:\\content\\HeroGymLastEdition\\src\\img\\trainer.png",
            "D:\\content\\HeroGymLastEdition\\src\\img\\training.png"
    };
    
    public SlideShowApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Slide Show App");
        setSize(1388, 768);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        slideLabel = new JLabel();
        contentPane.add(slideLabel);
        setContentPane(contentPane);

        // Initialize slide show
        currentSlideIndex = 0;
        showSlide();

        // Create a Timer to change slides every 3 seconds
        timer = new Timer(2300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSlideIndex = (currentSlideIndex + 1) % imagePaths.length;
                showSlide();
            }
        });
        timer.start();
    }

    private void showSlide() {
        String imagePath = imagePaths[currentSlideIndex];
        ImageIcon imageIcon = new ImageIcon(imagePath);
        slideLabel.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SlideShowApp().setVisible(true);
            }
        });
    }
}







