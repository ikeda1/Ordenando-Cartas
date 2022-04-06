/**
 * Carta
 */
public class Carta {

    // Atributos
    private String value;
    private String suit;

    // Construtor padrão
    public Carta(String line) {
        // Recebe uma string e divide o conteúdo para atribuir o valor e o naipe de cada carta
        String[] splitLine = line.split(" ");
        this.value = splitLine[0];
        this.suit = splitLine[1];
    }

    // Construtor coringa
    public Carta() {
        this.value = "curinga";
        this.suit = "";
    }

    // Retorna o valor da carta como Inteiro 
    // Getter
    private int getValue() {

        // Transforma palavra para letras minúsculas
        String value = this.value.toLowerCase();

        switch (value) {
            case "as": case "1": return 1;
            case "dois": case "2": return 2;
            case "tres": case "3": return 3;
            case "quatro": case "4": return 4;
            case "cinco": case "5":  return 5;
            case "seis": case "6": return 6;
            case "sete": case "7": return 7;
            case "oito": case "8": return 8;
            case "nove": case "9": return 9;
            case "dez": case "10": return 10;
            case "valete": return 11;
            case "dama": return 12;
            case "rei": return 13;
            case "curinga": return 0;
            default:
                System.out.println(value + " é inválido!");
                return -1;
        }
    }

    public String getCard() {
        // Foi utilizado substrings para garantir que as primeiras letras do valor e naipe sempre sejam maiúsculas, independente de como estiver escrito no arquivo lido.

        // Se for um coringa
        if (this.value.toLowerCase().equals("curinga")) return "Curinga";
        // Se for uma carta entre 2 e 10
        else if (getValue() > 1 && getValue() < 11) return getValue() + " de " + this.suit.substring(0, 1).toUpperCase() + this.suit.substring(1).toLowerCase();
        // Se for um As, Valete, Dama ou Rei
        else return this.value.substring(0, 1).toUpperCase() + this.value.substring(1).toLowerCase() + " de " + this.suit.substring(0, 1).toUpperCase() + this.suit.substring(1).toLowerCase();
    }

    // Compara valor de duas cartas
    public int compareCards(Carta card) {

        // Se for igual
        if (card.getValue() == getValue()) return 0;
        // Se for menor
        else if (card.getValue() < getValue()) return -1;
        // Se for maior
        else return 1;
    }
}