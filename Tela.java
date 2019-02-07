/** *****************************************************************************
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: <Mariana Lima> e <Nadime Centeno>
 * Data:  <08/02/2019>
 *
 * Declaro que este código foi elaborado por mim de forma individual e não
 * contém nenhum trecho de código de outro colega ou de outro autor, tais como
 * provindos de livros e apostilas, e páginas ou documentos eletrônicos da
 * Internet. Qualquer trecho de código de outra autoria que uma citação para o
 * não a minha está destacado com autor e a fonte do código, e estou ciente que
 * estes trechos não serão considerados para fins de avaliação. Alguns trechos
 * do código podem coincidir com de outros colegas pois estes foram discutidos
 * em sessões tutorias.
 * ****************************************************************************
 */
package exemplos;
import exemplos.PainelGrafo;
import exemplos.MostraResultadoDoGrafo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import util.Grafo;
import util.Utils;

/*
 *	TELA DA APLICAÇÂO 
 *
 * @author Mariana Lima
 * @author Nadime
 */
public class Tela extends JFrame {

	private static final String GRAFOS = "### GRAFOS ###\n";
	private static final long serialVersionUID = 1L;
	private JPanel _painelInfo;
	private JPanel _painelGrafo;
	private JPanel _painelInfoGrafo;
	private JPanel _painelSaidaDoGrafo;
	
	private JRadioButton _radioDirecionado;
	private JRadioButton _radioNaoDirecionado;
	private JRadioButton _radioVertice;
	private JRadioButton _radioAresta;
	private JRadioButton _radioValorado;
	private JRadioButton _radioNaoValorado;
	
	private JButton _botaoNovoGrafo;
	private JButton _botaoArvoreDeCobertura;
	
	private JTextArea _saidaDoGrafo;
	
	private Grafo _grafo;
	
	public Tela() {
		
	}
	
	/*
	 * Contrutor da classe
	 */
	public Tela(String titulo) throws HeadlessException {
		
		setLayout(new BorderLayout());
		setTitle(titulo);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(1000,670));
		setPreferredSize(getSize());
		setLocationRelativeTo(null);
		setResizable(true);
		
		/*
		 * Cria uma nova instancia do Grafo
		 */
		_grafo = new Grafo("");
		MostraResultadoDoGrafo.OWNER = this;
		
		getContentPane().add(getPainelInfo(), BorderLayout.NORTH);
		getContentPane().add(getPainelGrafo(), BorderLayout.CENTER);
		getContentPane().add(getPainelInfoGrafo(), BorderLayout.WEST);
		getContentPane().add(getPainelSaidaDoGrafo(), BorderLayout.EAST);
		//getContentPane().add(getPainelBotoes(), BorderLayout.SOUTH);
	}
	
	/*
	 * Cria painel para a saida do grafo
	 */
	private JPanel getPainelSaidaDoGrafo() {
		if (_painelSaidaDoGrafo == null) {
			_painelSaidaDoGrafo = new JPanel();
			
			_painelSaidaDoGrafo.setBorder(BorderFactory.createTitledBorder("Resultado do grafo"));
			_painelSaidaDoGrafo.setLayout(new FlowLayout());
			_painelSaidaDoGrafo.setSize(new Dimension(200, 150));
			
			_saidaDoGrafo = new JTextArea(GRAFOS, 45, 30);
			_saidaDoGrafo.setEditable(false);
			JScrollPane scrollPanel = new JScrollPane(_saidaDoGrafo);
			
			_painelSaidaDoGrafo.add(scrollPanel);
		}
		
		return _painelSaidaDoGrafo;
	}
	
	/*
	 * Cria painel com as informações do grafo.
	 * Se é para inserir um vertice ou aresta no grafo
	 */
	private JPanel getPainelInfoGrafo() {
		if (_painelInfoGrafo == null) {
			_painelInfoGrafo = new JPanel();
			
			_painelInfoGrafo.setBorder(BorderFactory.createTitledBorder("Inserir no Grafo"));
			_painelInfoGrafo.setLayout(new FlowLayout());
			_painelInfoGrafo.setSize(new Dimension(50, 200));
			
			_radioVertice = new JRadioButton("Vertice");
			_radioAresta = new JRadioButton("Aresta");
			_radioVertice.setSelected(true);
			
			final ButtonGroup grupoRadio = new ButtonGroup();
			grupoRadio.add(_radioVertice);
			grupoRadio.add(_radioAresta);
			
			_painelInfoGrafo.add(_radioVertice);
			_painelInfoGrafo.add(_radioAresta);
			
		}
		
		return _painelInfoGrafo;
	}
	
	/*
	 * Cria painel de informação da aplicação.
	 * Botão Novo Grafo -> Limpa a tela para ser gerado outro grafo
	 * Opções de grafo 'Direcionado' ou 'Não direcionado'
	 */
	private JPanel getPainelInfo() {
		if (_painelInfo == null) {
			_painelInfo = new JPanel();
			
			_painelInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
			_painelInfo.setLayout(new FlowLayout());
			_painelInfo.setSize(new Dimension(100, 50));
			
			_botaoNovoGrafo = new JButton("Novo Grafo");
			_botaoNovoGrafo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int escolha = JOptionPane.showConfirmDialog(null,"Deseja criar um novo grafo? ","Novo Grafo",JOptionPane.YES_NO_OPTION); 
					if (escolha == JOptionPane.YES_OPTION) {
						limpaTela();
						_radioDirecionado.setEnabled(true);
						_radioNaoDirecionado.setEnabled(true);
						_radioValorado.setEnabled(true);
						_radioNaoValorado.setEnabled(true);
					}
				}
			});
			
			_painelInfo.add(_botaoNovoGrafo);
			
			_radioDirecionado = new JRadioButton("Direcionado");
			_radioNaoDirecionado = new JRadioButton("Não direcionado");
			_radioDirecionado.setSelected(true);
			
			_radioValorado = new JRadioButton("Valorado");
			_radioNaoValorado = new JRadioButton("Não Valorado");
			_radioValorado.setSelected(true);
			
			final ButtonGroup grupoRadioDirecao = new ButtonGroup();
			grupoRadioDirecao.add(_radioDirecionado);
			grupoRadioDirecao.add(_radioNaoDirecionado);

			final ButtonGroup grupoRadioValorado = new ButtonGroup();
			grupoRadioValorado.add(_radioValorado);
			grupoRadioValorado.add(_radioNaoValorado);
			
			_painelInfo.add(_radioDirecionado);
			_painelInfo.add(_radioNaoDirecionado);
			
			_painelInfo.add(Utils.criaSeparadorVertical());

			_painelInfo.add(_radioValorado);
			_painelInfo.add(_radioNaoValorado);

			
		}
		return _painelInfo;
	}
	
	/*
	 * Cria painel onde o grafo é desenhado.
	 */
	private JPanel getPainelGrafo() {
		if (_painelGrafo == null) {
			_painelGrafo = new PainelGrafo(this, _grafo);
		}
		return _painelGrafo;
	}
        
	/*
	 * Metodo para limpar a tela.
	 */
	public void limpaTela() {
		_grafo = new Grafo("");
		((PainelGrafo) _painelGrafo).setGrafo(_grafo);
		_painelGrafo.repaint();
		_radioVertice.setSelected(true);
		_radioDirecionado.setSelected(true);
		_saidaDoGrafo.setText(GRAFOS);
		_radioValorado.setSelected(true);
	}
	
	public JRadioButton getRadioDirecionado() {
		return _radioDirecionado;
	}
	
	public JRadioButton getRadioNaoDirecionado() {
		return _radioNaoDirecionado;
	}
	
	public JRadioButton getRadioVertice() {
		return _radioVertice;
	}

	public JRadioButton getRadioAresta() {
		return _radioAresta;
	}

	public JRadioButton getRadioValorado() {
		return _radioValorado;
	}

	public void setRadioValorado(JRadioButton _radioValorado) {
		this._radioValorado = _radioValorado;
	}

	public JRadioButton getRadioNaoValorado() {
		return _radioNaoValorado;
	}

	public void setRadioNaoValorado(JRadioButton _radioNaoValorado) {
		this._radioNaoValorado = _radioNaoValorado;
	}
	
	/*
	 * Metodo inicial
	 * Executa a aplicação.
	 */
	public static void main(String[] args) {
		final Tela tela = new Tela("Trabalho Grafos");
		tela.setVisible(true);
	}

	public JButton get_botaoArvoreDeCobertura() {
		return _botaoArvoreDeCobertura;
	}

	public void set_botaoArvoreDeCobertura(JButton _botaoArvoreDeCobertura) {
		this._botaoArvoreDeCobertura = _botaoArvoreDeCobertura;
	}

}