import dao.ContratoDao;
import dao.ContratoDaoMock;
import dao.IContratoDao;
import org.junit.Assert;
import org.junit.Test;
import services.ContratoService;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        ContratoService service = new ContratoService(dao);
        service.salvar();
        Assert.assertEquals("Sucesso", service.getContrato());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        IContratoDao dao = new ContratoDao();
        ContratoService service = new ContratoService(dao);
        service.salvar();
        Assert.assertEquals("Sucesso", service.getContrato());
    }

    @Test
    public void buscarTest() {
        IContratoDao dao = new ContratoDaoMock();
        ContratoService service = new ContratoService(dao);
        service.salvar();
        String buscar = service.buscar();
        Assert.assertEquals("Contrato encontrado", buscar);
        Assert.assertEquals("Sucesso", service.getContrato());
    }

    @Test
    public void contratoNaoEncontradoBuscarTest() {
        IContratoDao dao = new ContratoDaoMock();
        ContratoService service = new ContratoService(dao);
        String buscar = service.buscar();
        Assert.assertEquals("Contrato não encontrado", buscar);
        Assert.assertNull(service.getContrato());
    }

    @Test
    public void excluirTest() {
        IContratoDao dao = new ContratoDaoMock();
        ContratoService service = new ContratoService(dao);
        service.salvar();
        String excluir = service.excluir();
        Assert.assertEquals("O Contrato foi excluído", excluir);
        Assert.assertNull(service.getContrato());
    }

    @Test
    public void contratoNaoEncontratoExcluirTest() {
        IContratoDao dao = new ContratoDaoMock();
        ContratoService service = new ContratoService(dao);
        String excluir = service.excluir();
        Assert.assertEquals("O contrato não existe para ser excluído", excluir);
        Assert.assertNull(service.getContrato());
    }

    @Test
    public void atualizarTest() {
        IContratoDao dao = new ContratoDaoMock();
        ContratoService service = new ContratoService(dao);
        service.salvar();
        String atualizar = service.atualizar();
        Assert.assertEquals("O contrato foi atualizado", atualizar);
        Assert.assertEquals("Atualizado", service.getContrato());
    }

    @Test
    public void contratoNaoEncontradoAtualizarTest() {
        IContratoDao dao = new ContratoDaoMock();
        ContratoService service = new ContratoService(dao);
        String atualizar = service.atualizar();
        Assert.assertEquals("O contrato não existe para ser atualizado", atualizar);
        Assert.assertNull(service.getContrato());
    }
}