package services;

import dao.IContratoDao;

import java.util.Objects;

public class ContratoService implements IContratoService{

    private String contrato;
    private final IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    @Override
    public void salvar() {
        contratoDao.salvar();
        setContrato("Sucesso");
    }

    @Override
    public String buscar() {
        String res;
        if(Objects.equals(getContrato(), "Sucesso")) {
            res = "Contrato encontrado";
        } else {
            res = "Contrato não encontrado";
        }
        return res;
    }

    @Override
    public String excluir() {
        String res;
        if(Objects.equals(getContrato(), null)) {
            res = "O contrato não existe para ser excluído";
        } else {
            setContrato(null);
            res = "O Contrato foi excluído";
        }
        return res;
    }

    @Override
    public String atualizar() {
        String res;
        if(Objects.equals(getContrato(), null)) {
            res = "O contrato não existe para ser atualizado";
        } else {
            setContrato("Atualizado");
            res = "O contrato foi atualizado";
        }
        return res;
    }
}
