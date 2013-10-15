package mvc;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Warstwa prezentacji
 * Klasa zajmująca się tworzeniem "okienek" i wyświetlaniem w nich danych pochodzących z modelu.
 * 
 * @author akocjan
 */
public class View extends JFrame 
{
    /**
     * Pole tekstowe z wynikiem.
     */
    private JTextField result = new JTextField(20);
    
    /**
     * Przycisk "Losuj"
     */
    private JButton    random = new JButton("Losuj");
    
    /**
     * Przycisk "Wyczyść"
     */
    private JButton    reset  = new JButton("Wyczyść");

    /**
     * Obiekt klasy modelu.
     */
    private Model model;

    /**
     * Konstruktor
     * Przyjmuje obiekt klasy Model i zapisuje go w prywatnej zmiennej.
     * 
     * @param model Obiekt klasy Model 
     */
    public View(Model model) 
    {
        this.model = model;

        this.result.setText(this.model.getValue().toString());
        this.result.setEditable(false);

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(this.result);
        content.add(this.random);
        content.add(this.reset);

        this.setContentPane(content);
        this.pack();

        this.setTitle("Rzut kostką");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Wstawia wartość liczbową do pola "result".
     * 
     * @param result Wynik
     */
    public void setResult(Integer result) 
    {
        this.result.setText(result.toString());
    }

    /**
     * Wyświetla w ramce komunikat błędu.
     * 
     * @param errMessage Treść błędu
     */
    public void showError(String errMessage) 
    {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    /**
     * Dodaje ActionListener do przycisku "Losuj"
     * 
     * @param al 
     */
    public void addRandomListener(ActionListener al) 
    {
        this.random.addActionListener(al);
    }

    /**
     * Dodaje ActionListener do przycisku "Wyczyść"
     * 
     * @param al 
     */
    public void addResetListener(ActionListener al) 
    {
        this.reset.addActionListener(al);
    }
}


