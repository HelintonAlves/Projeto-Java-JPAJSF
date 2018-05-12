/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.trainning.util;

import br.com.trainning.DAO.AgendaDAO;
import br.com.trainning.model.Agenda;
import java.util.List;

/**
 *
 * @author trainning
 */
public class TestarListar {

    public static void main(String[] args) {

        AgendaDAO dao = new AgendaDAO();

        List<Agenda> lista = dao.lista();

        for (Agenda agenda : lista) {

            System.out.println(agenda.getNome()+"-"+agenda.getEndereco());
        }

    }
}
