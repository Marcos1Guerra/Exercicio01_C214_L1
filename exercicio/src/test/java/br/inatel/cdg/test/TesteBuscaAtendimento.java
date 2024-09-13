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
        Atendimento renzo = buscaAtendimento.buscaAtendimento(1);

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
        Atendimento chris = buscaAtendimento.buscaAtendimento(2);

        //Faz assertion
        assertEquals("Chris", chris.getProfessor());
        assertEquals("19h30", chris.getHorario());
        assertEquals("noturno", chris.getPeriodo());
        assertEquals(8, chris.getSala());
        assertEquals(2, chris.getPredio());
    }

    @Test
    public void testeBuscaAtendimento3(){

        //Fiz a busca
        Atendimento soned = buscaAtendimento.buscaAtendimento(3);

        //Faz assertion
        assertEquals("Soned", soned.getProfessor());
        assertEquals("21h30", soned.getHorario());
        assertEquals("noturno", soned.getPeriodo());
        assertEquals(14, soned.getSala());
        assertEquals(3, soned.getPredio());
    }

    @Test
    public void testeBuscaAtendimento4(){

        //Fiz a busca
        Atendimento aquino = buscaAtendimento.buscaAtendimento(4);

        //Faz assertion
        assertEquals("Aquino", aquino.getProfessor());
        assertEquals("08h00", aquino.getHorario());
        assertEquals("integral", aquino.getPeriodo());
        assertEquals(19, aquino.getSala());
        assertEquals(4, aquino.getPredio());
    }

    @Test
    public void testeBuscaAtendimento5(){

        //Fiz a busca
        Atendimento victoria = buscaAtendimento.buscaAtendimento(6);

        //Faz assertion
        assertEquals("Victoria", victoria.getProfessor());
        assertEquals("19h30", victoria.getHorario());
        assertEquals("noturno", victoria.getPeriodo());
        assertEquals(22, victoria.getSala());
        assertEquals(6, victoria.getPredio());
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
    public void testeBuscaAtendimentoNaoPadrao(){

        //Fiz a busca com ID positivo diferente de 10 e 20
        Atendimento padrao = buscaAtendimento.buscaAtendimento(13);

        //Faz assertion
        assertEquals("Marcelo", padrao.getProfessor());
        assertEquals("10h30", padrao.getHorario());
        assertEquals("integral", padrao.getPeriodo());
        assertEquals(4, padrao.getSala());
        assertNotEquals(6, padrao.getPredio());
    }

    @Test
    public void testeBuscaAtendimentoNãoCorreto(){

        //Fiz a busca
        Atendimento aquino = buscaAtendimento.buscaAtendimento(4);

        //Faz assertion
        assertNotEquals("Fulano", aquino.getProfessor());
        assertNotEquals("08h30", aquino.getHorario());
        assertNotEquals("noturno", aquino.getPeriodo());
        assertNotEquals(11, aquino.getSala());
        assertNotEquals(1, aquino.getPredio());
    }

    @Test
    public void testeBuscaAtendimentoInexistentedeTodosDados(){

        //Fiz a busca
        Atendimento incognita = buscaAtendimento.buscaAtendimento(1);

        //Faz assertion
        assertNotEquals("incognita", incognita.getProfessor());
        assertNotEquals("incognita", incognita.getHorario());
        assertNotEquals("incognita", incognita.getPeriodo());
        assertNotEquals(0, incognita.getSala());
        assertNotEquals(0, incognita.getPredio());
    }

    @Test
    public void testeBuscaAtendimentoInvalidoProfessor(){

        //Fiz a busca com ID positivo diferente de 10 e 20
        Atendimento professor = buscaAtendimento.buscaAtendimento(1);

        //Faz assertion
        assertNotEquals("Marcelo", professor.getProfessor());
    }

    @Test
    public void testeBuscaAtendimentoInvalidoHorario(){

        //Fiz a busca com ID positivo diferente de 10 e 20
        Atendimento horario = buscaAtendimento.buscaAtendimento(2);

        //Faz assertion
        assertNotEquals("08h00", horario.getHorario());
    }

    @Test
    public void testeBuscaAtendimentoInvalidoPeriodo(){

        //Fiz a busca com ID positivo diferente de 10 e 20
        Atendimento periodo = buscaAtendimento.buscaAtendimento(3);

        //Faz assertion
        assertNotEquals("diurno", periodo.getPeriodo());
    }

    @Test
    public void testeBuscaAtendimentoInvalidoSala(){

        //Fiz a busca com ID positivo diferente de 10 e 20
        Atendimento sala = buscaAtendimento.buscaAtendimento(4);

        //Faz assertion
        assertNotEquals("4", sala.getSala());
    }

    @Test
    public void testeBuscaAtendimentoInvalidoPredio(){

        //Fiz a busca com ID positivo diferente de 10 e 20
        Atendimento predio = buscaAtendimento.buscaAtendimento(6);

        //Faz assertion
        assertNotEquals("5", predio.getPredio());
    }

    @Test
    public void testeBuscaAtendimentoValido01(){
        boolean atendimentoValido = buscaAtendimento.verificaArrayListExistente(1);

        assertTrue(atendimentoValido);
    }

    @Test
    public void testeBuscaAtendimentoValido02(){
        boolean atendimentoValido = buscaAtendimento.verificaArrayListExistente(2);

        assertTrue(atendimentoValido);
    }
    @Test
    public void testeBuscaAtendimentoValido03(){
        boolean atendimentoValido = buscaAtendimento.verificaArrayListExistente(3);

        assertTrue(atendimentoValido);
    }
    @Test
    public void testeBuscaAtendimentoValido04(){
        boolean atendimentoValido = buscaAtendimento.verificaArrayListExistente(4);

        assertTrue(atendimentoValido);
    }
    @Test
    public void testeBuscaAtendimentoValido06(){
        boolean atendimentoValido = buscaAtendimento.verificaArrayListExistente(6);

        assertTrue(atendimentoValido);
    }

    @Test
    public void testeBuscaAtendimentoInValido(){
        boolean atendimentoValido = buscaAtendimento.verificaArrayListExistente(-8);

        assertFalse(atendimentoValido);
    }

    @Test
    public void testeBuscaAtendimentoInValido02(){
        boolean atendimentoValido = buscaAtendimento.verificaArrayListExistente(0);

        assertFalse(atendimentoValido);
    }
}
