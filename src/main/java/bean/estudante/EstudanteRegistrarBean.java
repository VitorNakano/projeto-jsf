package bean.estudante;

import model.Estudante;

import javax.el.LambdaExpression;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

import static java.util.Arrays.asList;

@Named
@ViewScoped
public class EstudanteRegistrarBean implements Serializable {
    private Estudante estudante = new Estudante();
    private String[] nomesArray = {"Teste", "de", "JSF"};
    private List<String> nomesList = asList("Teste", "de", "JSF");
    private Set<String> nomesSet = new HashSet<>(asList("Kawori", "Kousei", "Tsubaki", "Arima"));
    private Map<String, String> nomesMap = new HashMap<>();
    private boolean mostrarNotas;


    public void exibirNotas() {
        this.mostrarNotas = true;
    }

    public void esconderNotas() {
        this.mostrarNotas = false;
    }

    public boolean isMostrarNotas() {
        return mostrarNotas;
    }

    public void setMostrarNotas(boolean mostrarNotas) {
        this.mostrarNotas = mostrarNotas;
    }

    public void calcularCubo(LambdaExpression le, long value) {
        long result = (long) le.invoke(FacesContext.getCurrentInstance().getELContext(), value);
        System.out.println(result);
    }

    {
        nomesMap.put("Kawori", "Violinist");
        nomesMap.put("Kousei", "Pianist");
        nomesMap.put("Tsubaki", "Friend");

//        for (Map.Entry<String, String> entry : nomesMap.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
    }

    public void executar() {
        System.out.println("Fazendo uma busca no BD");
        System.out.println("Processando os dados");
        System.out.println("Exibindo os dados");
    }

    public void executar(String param) {
        System.out.println("Fazendo uma busca no BD com o PARAMETRO: " + param);
        System.out.println("Processando os dados");
        System.out.println("Exibindo os dados");
    }

    public String executarRetorno(String param) {
        return "Mais um teste por ai " + param;
    }

    public String irParaIndex2() {
        return "index2?faces-redirect=true";
    }

    public Map<String, String> getNomesMap() {
        return nomesMap;
    }

    public void setNomesMap(Map<String, String> nomesMap) {
        this.nomesMap = nomesMap;
    }

    public Set<String> getNomesSet() {
        return nomesSet;
    }

    public void setNomesSet(Set<String> nomesSet) {
        this.nomesSet = nomesSet;
    }

    public List<String> getNomesList() {
        return nomesList;
    }

    public void setNomesList(List<String> nomesList) {
        this.nomesList = nomesList;
    }

    public String[] getNomesArray() {
        return nomesArray;
    }

    public void setNomesArray(String[] nomesArray) {
        this.nomesArray = nomesArray;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
