package bean.view;


import bean.dependent.TesteDependentBean;
import bean.session.TesteSessionBean;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@ViewScoped
public class TesteViewBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    private final TesteDependentBean dependentBean;
    private final TesteSessionBean sessionBean;

    @Inject
    public TesteViewBean(TesteDependentBean dependentBean, TesteSessionBean sessionBean) {
        this.dependentBean = dependentBean;
        this.sessionBean = sessionBean;
    }

    @PostConstruct
    public void init() {
        System.out.println("Entrando no PostConstruct do ViewScoped");
        personagens = asList("Naruto", "Hinata", "Minato");
    }

    public List<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<String> personagens) {
        this.personagens = personagens;
    }

    public void selecionarPersonagem() {
        System.out.println(sessionBean.getEstudante().getNome());
        if(sessionBean.getEstudante().getNome().equals("Vitor")) {
            int index = ThreadLocalRandom.current().nextInt(3);
            String personagem = personagens.get(index);
            personagemSelecionado.add(personagem);
            dependentBean.getPersonagemSelecionado().add(personagem);
        }
    }

    public TesteDependentBean getDependentBean() {
        return dependentBean;
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
}
