package mvc;

/**
 * Warstwa danych
 * Klasa zajmująca się obsługą logiki biznesowej.
 * 
 * @author akocjan
 */
public class Model 
{
    /**
     * Baza danych, na której będziemy operować.
     */
    private Integer num;

    /**
     * Konstruktor - wykonuje się samoczynnie podczas tworzenia obiektu.
     */
    public Model() 
    {
        this.reset();
    }

    /**
     * Resetuje naszą bazę danych do wartości początkowej.
     */
    public void reset() 
    {
        this.num = 0;
    }

    /**
     * Umieszcza w bazie danych losową wartość od 1 do 6.
     */
    public void random() 
    {
        this.num = 1 + (int)(Math.random() * 6);
    }

    /**
     * Zwraca aktualną wartość z bazy danych.
     * 
     * @return Integer
     */
    public Integer getValue() 
    {
        return this.num;
    }
}