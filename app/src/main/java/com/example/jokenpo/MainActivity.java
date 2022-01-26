package com.example.jokenpo;

import static com.example.jokenpo.R.id.imgPedra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int pPlayer = 0, pBot = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void escolherPedra(View view) {
        TextView txtEscolha = findViewById(R.id.txtEscolha);
        txtEscolha.setText("Pedra foi escolhida");
        jogar("Pedra");

    }

    public void escolherPapel(View view) {
        TextView txtEscolha = findViewById(R.id.txtEscolha);
        txtEscolha.setText("Papel foi escolhida");
        jogar("Papel");

    }

    public void escolherTesoura(View view) {
        TextView txtEscolha = findViewById(R.id.txtEscolha);
        txtEscolha.setText("Tesoura foi escolhida");
        jogar("Tesoura");

    }

    public void jogar(String escolhaPlayer) {
        ImageView imgJogadaBot = findViewById(R.id.imgJogadaBot);
        TextView txtResultado = findViewById(R.id.txtResultado);
        TextView txtTabela = findViewById(R.id.txtTabela);
        TextView txtEscolha = findViewById(R.id.txtEscolha);
        Random random = new Random();
        int jogada = random.nextInt(3);
        String escolhaBot = null;
        if (jogada == 0) {
            escolhaBot = "Pedra";
            imgJogadaBot.setImageResource(R.drawable.pedra);
        } else if (jogada == 1) {
            escolhaBot = "Papel";
            imgJogadaBot.setImageResource(R.drawable.papel);
        } else if (jogada == 2) {
            escolhaBot = "Tesoura";
            imgJogadaBot.setImageResource(R.drawable.tesoura);
        }
        if (escolhaBot != null) {
            switch (escolhaBot) {
                case "Pedra":
                    if (escolhaPlayer == "Pedra") {
                        txtResultado.setText("Empatou");
                        txtTabela.setText(this.pPlayer + " : " + this.pBot);
                    } else if (escolhaPlayer == "Papel") {
                        txtResultado.setText("Venceu");
                        this.pPlayer++;
                        txtTabela.setText(this.pPlayer + " : " + this.pBot);
                    } else if (escolhaPlayer == "Tesoura") {
                        txtResultado.setText("Perdeu");
                        this.pBot++;
                        txtTabela.setText(this.pPlayer + " : " + this.pBot);
                    }
                    break;
                case "Papel":
                    if (escolhaPlayer == "Pedra") {
                        txtResultado.setText("Perdeu");
                        this.pBot++;
                        txtTabela.setText(this.pPlayer + " : " + this.pBot);
                    } else if (escolhaPlayer == "Papel") {
                        txtResultado.setText("Empate");
                        txtTabela.setText(this.pPlayer + " : " + this.pBot);
                    } else if (escolhaPlayer == "Tesoura") {
                        txtResultado.setText("Venceu");
                        this.pPlayer++;
                        txtTabela.setText(this.pPlayer + " : " + this.pBot);
                    }
                    break;
                case "Tesoura":
                    if (escolhaPlayer == "Pedra") {
                        txtResultado.setText("Venceu");
                        this.pPlayer++;
                        txtTabela.setText(this.pPlayer + " : " + this.pBot);
                    } else if (escolhaPlayer == "Papel") {
                        txtResultado.setText("Perdeu");
                        this.pBot++;
                        txtTabela.setText(this.pPlayer + " : " + this.pBot);
                    } else if (escolhaPlayer == "Tesoura") {
                        txtResultado.setText("Empate");
                        txtTabela.setText(this.pPlayer + " : " + this.pBot);
                    }
                    break;

            }
            if (this.pPlayer == 3 || this.pBot == 3) {
                txtResultado.setText("");
                txtEscolha.setText("Faça a sua jogada!");
                this.pBot = 0;
                this.pPlayer = 0;
                txtTabela.setText(this.pPlayer + " : " + this.pBot);
            }
        }
    }
}
