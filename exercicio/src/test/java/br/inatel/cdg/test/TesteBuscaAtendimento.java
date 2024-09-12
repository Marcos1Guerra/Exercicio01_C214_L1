package br.inatel.cdg.test;

import br.inatel.cdg.BuscaAtendimento;
import br.inatel.cdg.Atendimento;
import br.inatel.cdg.AtendimentoService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteBuscaAtendimento {

    AtendimentoService service;
    BuscaAtendimento buscaAtendimento;

    @Before
    public void setup(){
        //Criando o contexo do meu teste com o Mock (serviço mock)
        service = new MockAtendimentoService();
        buscaAtendimento = new BuscaAtendimento(service);
    }

    @Test
    public void testeBuscaAtendimento1(){

        //Fiz a busca
        Atendimento renzo = buscaAtendimento.buscaAtendimento(10);

        //Faz assertion
        assertEquals("Renzo", renzo.getProfessor());
        assertEquals("13h30", renzo.getHorario());
        assertEquals("integral", renzo.getPeriodo());
        assertEquals(2, renzo.getSala());
        assertEquals(1, renzo.getPredio());

    }

    @Test
    public void testeBuscaAtendimento2(){

        //Fiz a busca
        Atendimento chris = buscaAtendimento.buscaAtendimento(20);

        //Faz assertion
        assertEquals("Chris", chris.getProfessor());
        assertEquals("19h30", chris.getHorario());
        assertEquals("noturno", chris.getPeriodo());
        assertEquals(8, chris.getSala());
        assertEquals(2, chris.getPredio());

    }

    @Test
    public void testeBuscaAtendimentoPadrao(){

        //Fiz a busca com ID positivo diferente de 10 e 20
        Atendimento padrao = buscaAtendimento.buscaAtendimento(9);

        //Faz assertion
        assertEquals("Marcelo", padrao.getProfessor());
        assertEquals("10h30", padrao.getHorario());
        assertEquals("integral", padrao.getPeriodo());
        assertEquals(4, padrao.getSala());
        assertEquals(1, padrao.getPredio());

    }

    @Test
    public void testeBuscaAtendimentoValido(){

        //Faz a busca de um inimigo válido (id = 10 ou id = 20 ou ID positivo)
        boolean atendimentoValido = buscaAtendimento.verificaArrayListExistente(10);

        assertTrue(atendimentoValido);
    }

    @Test
    public void testeBuscaAtendimentoInValido(){

        //Faz a busca de um inimigo inválido (id negativo)
        boolean atendimentoValido = buscaAtendimento.verificaArrayListExistente(-8);

        assertFalse(atendimentoValido);
    }
}
