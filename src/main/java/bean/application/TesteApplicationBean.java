package bean.application;

import bean.dependent.TesteDependentBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable {
    private List<String> categoriaList;
    private final TesteDependentBean dependentBean;

    @Inject
    public TesteApplicationBean(TesteDependentBean dependentBean) {
        this.dependentBean = dependentBean;
    }

    @PostConstruct
    public void init() {
        System.out.println("Entrando no PostConstruct do ApplicationScoped");
        categoriaList = asList("RPG", "Sci-Fi", "Terror");
        dependentBean.getCategoriasList().addAll(asList("Comédia", "Romance"));
    }

    public TesteDependentBean getDependentBean() {
        return dependentBean;
    }

    public void mudarLista() {
        categoriaList = asList("RPG", "Sci-Fi", "Terror", "Comédia");
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }
}
