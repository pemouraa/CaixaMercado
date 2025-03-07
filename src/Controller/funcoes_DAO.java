/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import static View.TelaCaixa.txtCod;
import static View.TelaCaixa.txtContato;
import static View.TelaCaixa.txtCpf;
import static View.TelaCaixa.txtNome2;
import static View.TelaCaixa.txtQuant;
import static View.TelaCaixa.txtQuant2;
import static View.TelaCaixa.txtProduto;
import static View.TelaCaixa.txtPreco2;
import static View.TelaCaixa.txtTotal;
import static View.TelaCaixa.txtPreco;

/**
 *
 * @author Gabriel
 */
public class funcoes_DAO {

    public static void adicionar() {
        String nome = txtProduto.getText();
        String quant = txtQuant.getText();

        txtNome2.append(nome + "\n");
        txtQuant2.append(quant + "\n");

        double val1 = Double.parseDouble(txtPreco.getText());
        int val2 = Integer.parseInt(txtQuant.getText());
        double valor = val1 * val2;

        txtPreco2.append(valor + "\n");
        
        String text = txtPreco2.getText();
    
        String[] lines = text.split("\n");

        double total = 0.0;

        for (String line : lines) {
            try {
                if (!line.trim().isEmpty()) {
                    total += Double.parseDouble(line.trim());
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter o valor: " + line);
            }
        }

        txtTotal.setText(String.format("%.2f", total));
        
    }
    
    public static void limpar(){
        txtProduto.setText("");
        txtCpf.setText("");
        txtContato.setText("");
        txtCod.setText("");
        txtQuant.setText("");
        txtPreco.setText("");
        txtNome2.setText("");
        txtQuant2.setText("");
        txtPreco2.setText("");
        txtTotal.setText("");
    }
}
