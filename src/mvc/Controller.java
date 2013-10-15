package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Kontroler
 * Zajmuje się obsługą żądań użytkownika; Komunikuje widok z modelem.
 * 
 * @author akocjan
 */
public class Controller 
{
    /**
     * Obiekt klasy modelu.
     */
    private Model model;
    
    /**
     * Obiekt klasy widoku.
     */
    private View  view;

    /**
     * Konstruktor
     * Dodaje obiekty klas Model i View do prywatnych zmiennych.
     * Tworzy "słuchaczy" i umieszcza ich w widoku.
     * 
     * @param model Obiekt modelu
     * @param view Obiekt widoku
     * @see mvc.View#addRandomListener(java.awt.event.ActionListener)
     * @see mvc.View#addRandomListener(java.awt.event.ActionListener)
     */
    public Controller(Model model, View view) 
    {
        this.model = model;
        this.view  = view;

        this.view.addRandomListener(new RandomListener());
        this.view.addResetListener(new ResetListener());
    }

    /**
     * Słuchacz przycisku "Losuj", wywoływany jest w momencie jego wciśnięcia.
     * 
     * @see mvc.View#addRandomListener(java.awt.event.ActionListener) 
     */
    class RandomListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try {
                model.random();
                view.setResult(model.getValue());
            } catch (NumberFormatException nfex) {
                view.showError("Wystąpił błąd: '" + nfex + "'");
            }
        }
    }

    /**
     * Słuchacz przycisku "Wyczyść", wywoływany jest w momencie jego wciśnięcia.
     * 
     * @see mvc.View#addRandomListener(java.awt.event.ActionListener) 
     */
    class ResetListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            model.reset();
            view.setResult(model.getValue());
        }
    }
}
