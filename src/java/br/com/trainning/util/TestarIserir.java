/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.trainning.util;

import br.com.trainning.DAO.AgendaDAO;
import br.com.trainning.model.Agenda;

/**
 *
 * @author trainning
 */
public class TestarIserir {
    
    public static void main(String[] args) {
        
        Agenda agenda = new Agenda();
        agenda.setNome("Ric");
        agenda.setEndereco("Av Paulista");
        agenda.setCidade("São Paulo");
        agenda.setUf("SP");
        agenda.setTelefone("000000");
        agenda.setCelular("9999999999");
        agenda.setEmail("teste@teste.com");
        
        AgendaDAO dao = new AgendaDAO();
        dao.salvar(agenda);
        
    }
}
