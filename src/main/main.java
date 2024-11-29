package main;

public class main {

    public String[] asignaciones  = {"Ds","Ec","Mt","Tp","BD","Sc","SO"};
    public int[] horasArray = {5,5,4,5,5,5,4};

    public String[][] hgrupo = new String[5][8];
    public String[][] hp = new String[5][8];

    public static void main(String[] args) {
        main m = new main();
        m.genhorarios();
        m.printhorario();
    }

    public void genhorarios() {
        int n = horasArray.length;
        int horas;
        String[] row = new String[8];
        boolean siExiste = true;           // Bool para verificar si la materia esta asignada en el dia anterior
        int hd;
        System.out.println("Horario de Grupo: ");
//        System.out.println("Prints para el Debug: ");//Horas Diarias
        for(int i = 0; i < n; i++) {        //Recorremos las materias
            horas = horasArray[i];          //Asignamos las horas de la materia
            for(int j = 0; j < 5 ; j++){  //Recorremos el horario de Grupo empezando por Dias y luego horas
                hd = 1;
                for(int k = 0; k<8;k++){
                    if(horas > 0){
                        if(hd < 3){
                            if(j > 0){
                                for(int l = 0; l<8;l++){
                                    if (row[l] != null && row[l].equals(asignaciones[i])){
                                        siExiste = false;
                                    }
                                }
                            }
                            if(siExiste){
                                if (hp[j][k] == null  && hgrupo[j][k] == null ) {
                                    hgrupo[j][k] = asignaciones[i];
                                    hp[j][k] = asignaciones[i];
                                    horas = horas - 1;
                                    hd = hd + 1;
                                }
                            }else{
                                if (j == 4) {
                                    if ((hp[j][k] == null || hp[j][k].isEmpty()) && (hgrupo[j][k] == null || hgrupo[j][k].isEmpty())) {
                                        hgrupo[j][k] = asignaciones[i];
                                        hp[j][k] = asignaciones[i];
                                        horas = horas - 1;
                                        hd = hd + 1;
                                    }
                                }
                                siExiste = true;
                            }
                        }
                    }
                }
                for(int k = 0; k<8;k++){
                    row[k] = hp[j][k];
                }
            }
        }
    }

    public void printhorario(){
        System.out.print("Dias =======> ");
        for(int i=0;i<5;i++){
            System.out.print("Dia " + (i+1));
        }
        System.out.println();
        for(int i=0;i<8;i++){
            System.out.print("Hora " + (i+7) + ":00 ==> ");
            for(int j=0;j<5;j++){
                System.out.print("[" + hgrupo[j][i] + "]");
            }
            System.out.println();
        }
    }
}
