package br.inatel.cdg.test;

import br.inatel.cdg.AtendimentoService;

import java.util.ArrayList;

public class MockAtendimentoService implements AtendimentoService {

    @Override
    public String busca(int id) {

        if (id == 1){
            return AtendimentoConst.RENZO;
        }else if (id == 2){
            return AtendimentoConst.CHRIS;
        }else if (id == 3){
            return AtendimentoConst.SONED;
        }else if (id == 4){
            return AtendimentoConst.AQUINO;
        }else if (id == 6){
            return AtendimentoConst.VICTORIA;
        }else if(id < 0){
            return AtendimentoConst.INEXISTENTE;
        }else{
            return AtendimentoConst.PADRAO;
        }
    }

    @Override
    public boolean atendimentoExistente(int id) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);

        for (int i=0; i < list.size(); i++){
            if (list.get(i).equals(id)) {
                return true;
            }
        }

        return false;
    }
}
