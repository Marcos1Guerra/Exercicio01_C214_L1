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

        return new Atendimento(jsonObject.get("professor").getAsString(),
                jsonObject.get("horario").getAsString(),
                jsonObject.get("periodo").getAsString(),
                jsonObject.get("sala").getAsInt(),
                jsonObject.get("predio").getAsInt());
    }

    public boolean verificaArrayListExistente(int id){
        boolean atendimentoExistente = atendimentoService.atendimentoExistente(id);

        if (atendimentoExistente){
            return true;
        }else{
            return false;
        }
    }

}
