/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.trainning.controller;

import br.com.trainning.DAO.AgendaDAO;
import br.com.trainning.model.Agenda;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author trainning
 */
@ManagedBean
@SessionScoped
public class ControllerAgenda {
    
    private Agenda contatoB;
    private DataModel listaContatos;

    public ControllerAgenda() {
        contatoB=new Agenda();
        
    }
    
    public  void novoContato(){
        setContatoB (new Agenda());
    }
//método salvar
    public String salvaContato() {
        AgendaDAO cd = new AgendaDAO();
        if (cd.salvar(getContatoB())) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            // lança um menssagem na pagina 
            contexto.addMessage(null, new FacesMessage(FacesMessage.
                    SEVERITY_INFO, "Cadastrado com sucesso!!", ""));
            return "listarcontatos";
        }
        return "erro";
    }
    
    //método editar
    public String editarContato() {
        AgendaDAO cd = new AgendaDAO();
        if (cd.atualizar(getContatoB())) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            // lança um menssagem na pagina 
            contexto.addMessage(null, new FacesMessage(FacesMessage.
                    SEVERITY_INFO, "Atualizado com sucesso!!", ""));
            return "listarcontatos";
        }
        return "erro";
    }    
    
    //método remover
    public String excluirContato() {
        AgendaDAO cd = new AgendaDAO();
        if (cd.remover(getContatoB())) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            // lança um menssagem na pagina 
            contexto.addMessage(null, new FacesMessage(FacesMessage.
                    SEVERITY_INFO, "Removido com sucesso!!", ""));
            return "listarcontatos";
        }
        return "erro";
    }
    
    //método selecionar
    public void selecionarContatos() {
       contatoB =(Agenda)listaContatos.getRowData();
    }    
    
    public Agenda getContatoB() {
        return contatoB;
    }

    public void setContatoB(Agenda contatoB) {
        this.contatoB = contatoB;
    }

    public DataModel getListaContatos() {
        AgendaDAO cd = new AgendaDAO();
        listaContatos = new ListDataModel(cd.lista());
        return listaContatos;
    }

    public void setListaContatos(DataModel listaContatos) {
        this.listaContatos = listaContatos;
    }  
    
}
