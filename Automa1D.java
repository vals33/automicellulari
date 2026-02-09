class Automa1D {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private int[] striscia;
    private int regola;

    public Automa1D(int larghezza, int regola) {
        this.striscia = new int[larghezza];
        this.regola = regola;
        striscia[larghezza / 2] = 1;

    }
    
    public int calcolaStato(int sinistra, int centro, int destra) {
        int indice = (sinistra << 2) | (centro << 1) | destra;

        // TODO Completa qui: in base a sinistra, centro, destra e la "regola"
        // devi calcolare il nuovo stato
        return (regola >> indice) & 1;
    }

    public void nextStato() {
        int[] nuovoStato = new int[striscia.length];
        
        
        for (int i = 0; i < striscia.length; i++) {
            // Gestisce i vicini con bordi a 0 
            int sinistra = (i == 0) ? 0 : striscia[i - 1];
            int centro = striscia[i];
            int destra = (i == striscia.length - 1) ? 0 : striscia[i + 1];
            // Calcola e assegna il nuovo stato
            nuovoStato[i] = calcolaStato(sinistra, centro, destra);
        }
        // TODO Completa qui:
        // per ogni cella, prendi i vicini e calcola il nuovo stato usando "calcolaStato"
        striscia = nuovoStato;
    }

    public void stampa() {
        for (int cella : striscia) {
            System.out.print(cella == 1 ? ANSI_PURPLE+ "█"+ANSI_RESET : " ");
        }
        System.out.println();
    }

    

    public static void main(String[] args) {
        
        
    
        // Prova diverse regole: 30, 90, 110, 184
        int[] regoleDaProvare = {30, 90, 110, 184};
        for (int regola : regoleDaProvare) {
            System.out.println("Regola " + regola + ":");
            Automa1D ac = new Automa1D(61, regola); 
            for (int i = 0; i < 30; i++) { // 30 generazioni
                ac.stampa();
                ac.nextStato();
            }
            System.out.println(); // Spazio tra regole
        }
    
        // Esempio conversione binario/decimale
        String binario = "01101110"; // Per regola 110
        int numero = Integer.parseInt(binario, 2); // Output: 110
        String binarioDaDec = Integer.toBinaryString(110); // Output: "1101110"
    }
}
