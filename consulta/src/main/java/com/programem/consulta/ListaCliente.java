package com.programem.consulta;

public class ListaCliente {
    
    String listaCliente(Iterable<Cliente> lista){
        String html = "";

        for(Cliente c : lista){
            html = html +
            "<h1>"+c.getNome()+"</h1>"+
            c.getIdade()+"<br>"+
            c.getEndereco()+"<br>"+
            "<br>"
            ;
        }
        return html;
    }
}