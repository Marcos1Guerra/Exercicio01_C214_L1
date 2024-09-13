package br.inatel.cdg;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaAtendimento {

    AtendimentoService atendimentoService;

    public BuscaAtendimento(AtendimentoService service){

        this.atendimentoService = service;
    }

    public Atendimento buscaAtendimento(int id){
        String atendimentoJson = atendimentoService.busca(id);

        JsonObject jsonObject = JsonParser.parseString(atendimentoJson).getAsJsonObject();

        int sala = jsonObject.get("sala").getAsInt();
        int predio = escolhaDoPredio(sala);

        return new Atendimento(
                jsonObject.get("professor").getAsString(),
                jsonObject.get("horario").getAsString(),
                jsonObject.get("periodo").getAsString(),
                jsonObject.get("sala").getAsInt(),
                predio);
    }

    public boolean verificaArrayListExistente(int id){
        boolean atendimentoExistente = atendimentoService.atendimentoExistente(id);

        if (atendimentoExistente){
            return true;
        }else{
            return false;
        }
    }

    private int escolhaDoPredio(int sala) {
        if (sala >= 1 && sala <= 5) {
            return 1;
        } else if (sala >= 6 && sala <= 10) {
            return 2;
        } else if (sala >= 11 && sala <= 15) {
            return 3;
        } else if (sala >= 16 && sala <= 20) {
            return 4;
        } else {
            return 6; // Valor padrão ou indicar prédio não definido
        }
    }
}
