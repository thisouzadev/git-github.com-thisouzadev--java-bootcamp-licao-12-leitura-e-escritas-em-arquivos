package agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
  private List<Contato> contatos;
  private File arquivobancoDados;

  public Agenda() {
    this.contatos = new ArrayList<Contato>();
    this.arquivobancoDados = new File(
        "C:Documentos\\Java\\3-manipulacao-de-textos-e-arquivos\\1-leitura-e-escritas-em-arquivos\\banco.txt ");
  }

  // public void adicionarContato(Contato contato) {
  // this.contatos.add(contato);
  // System.out.println("Contato adicionado com sucesso!");
  // }

  // public void exibirContatos() {
  // for (Contato contato : contatos) {
  // System.out.println("Nome: " + contato.getNome());
  // System.out.println("Telegone: " + contato.getTelefone());
  // }
  // }

  public void adicionarContato(Contato contato) {
    try {
      FileWriter escritorArquivo = null;
      BufferedWriter bufferedEscritor = null;

      if (!this.arquivobancoDados.exists()) {
        arquivobancoDados.createNewFile();
      }
      escritorArquivo = new FileWriter(arquivobancoDados, true);
      bufferedEscritor = new BufferedWriter(escritorArquivo);
      bufferedEscritor.write(contato.toString());
      bufferedEscritor.newLine();
      bufferedEscritor.flush();

      escritorArquivo.close();
      bufferedEscritor.close();

      this.contatos.add(contato);
      System.out.println("Contato adicionado com suceeso!");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void exibirContatos() {
    try {
      FileReader leitorArquivo = null;
      BufferedReader bufferedLeitor = null;
      if (arquivobancoDados.exists()) {
        leitorArquivo = new FileReader(arquivobancoDados);
        bufferedLeitor = new BufferedReader(leitorArquivo);

        String conteudoLinha = bufferedLeitor.readLine();
        while (conteudoLinha != null) {
          System.out.println(conteudoLinha);
          conteudoLinha = bufferedLeitor.readLine();
        }
        leitorArquivo.close();
        bufferedLeitor.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
