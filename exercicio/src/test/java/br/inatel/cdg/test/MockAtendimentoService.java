package br.inatel.cdg.test;

import br.inatel.cdg.AtendimentoService;

import java.util.ArrayList;

public class MockAtendimentoService implements AtendimentoService {


    @Override
    public String busca(int id) {

        if (id == 10){
            return AtendimentoConst.RENZO;
        }else if (id == 20){
            return AtendimentoConst.CHRIS;
        }else if(id < 0){
            return AtendimentoConst.INEXISTENTE;
        }else{
            return AtendimentoConst.PADRAO;
        }
    }

    @Override
    public boolean atendimentoExistente(int id) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);

        for (int i=0; i < list.size(); i++){
            if (list.get(i).equals(id) || list.get(i).equals(id)){
                return true;
            }else{
                return false;
            }
        }

        return false;
    }
}
