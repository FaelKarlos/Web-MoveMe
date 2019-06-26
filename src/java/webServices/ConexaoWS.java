/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import model.bean.Administrador;
import model.bean.ListaAdministrador;
import model.bean.ListaMotorista;
import model.bean.ListaPassageiro;
import model.bean.Motorista;
import model.bean.Passageiro;

/**
 *
 * @author Outros
 */
public class ConexaoWS {
           

    
    
       public List<Administrador> administradorGetAll() throws Exception {
		String url = "http://b8439639.ngrok.io/MoveMe/rest/administrador/getall";
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		//System.out.println(response.toString());
                
             List<Administrador> list = new Gson().fromJson(response.toString(),ListaAdministrador.class);
             
             return list;
 
	}
       
       public List<Motorista> motoristaGetAll() throws Exception {
		String url = "http://b8439639.ngrok.io/MoveMe/rest/motorista/getall";
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		//System.out.println(response.toString());
                
             List<Motorista> list = new Gson().fromJson(response.toString(),ListaMotorista.class);
             
             return list;
 
	}
       public List<Passageiro> passageiroGetAll() throws Exception {
           
		String url = "http://b8439639.ngrok.io/MoveMe/rest/passageiro/getall";
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		//System.out.println(response.toString());
                
             List<Passageiro> list = new Gson().fromJson(response.toString(),ListaPassageiro.class);
             
             return list;
	}
       
       
       public void inserirAdmistrador(Administrador novo){
           
           
          String administrador = new Gson().toJson(novo);
           try {
                //Localização do web service

                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/administrador/inserir");

                //Abre a conexão
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                try {
                    //Defini o verbo HTTP
                    connection.setRequestMethod("POST");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }

                //Cabeçalhos da requisição
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);

                //Prepara para enviar dados para a requisição
                OutputStream writer = connection.getOutputStream();

                //Envia o Passageiro passado no construtor
                writer.write(administrador.getBytes());
                writer.flush();

                //Pega o que foi retornado pelo web service
                BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

                String retorno;
                //Escreve o retorno em uma variável
                while ((retorno = br.readLine()) != null) {
                    System.out.println(retorno);
                }

                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();

                //Imprimi a resposta
              //  System.out.println(resposta.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       
       
       
       public void alterarAdministrador(Administrador novo){
        String administrador = new Gson().toJson(novo);
       
           try {
                //Localização do web service

                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/administrador/editar");

                //Abre a conexão
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                try {
                    //Defini o verbo HTTP
                    connection.setRequestMethod("PUT");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }

                //Cabeçalhos da requisição
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);

                //Prepara para enviar dados para a requisição
                OutputStream writer = connection.getOutputStream();

                //Envia o Passageiro passado no construtor
                writer.write(administrador.getBytes());
                writer.flush();

                //Pega o que foi retornado pelo web service
                BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

                String retorno;
                //Escreve o retorno em uma variável
                while ((retorno = br.readLine()) != null) {
                    System.out.println("Retorna com alterações: " + retorno);
                }

                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();

                //Imprimi a resposta
               System.out.println("editado com sucesso!");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
       }
       
       
       
       
       
       
       
       public void alterarMotorista(Motorista novo){
        String motorista = new Gson().toJson(novo);
       
           try {
                //Localização do web service

                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/motorista/editar");

                //Abre a conexão
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                try {
                    //Defini o verbo HTTP
                    connection.setRequestMethod("PUT");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }

                //Cabeçalhos da requisição
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);

                //Prepara para enviar dados para a requisição
                OutputStream writer = connection.getOutputStream();

                //Envia o Passageiro passado no construtor
                writer.write(motorista.getBytes());
                writer.flush();

                //Pega o que foi retornado pelo web service
                BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

                String retorno;
                //Escreve o retorno em uma variável
                while ((retorno = br.readLine()) != null) {
                    System.out.println("Retorna com alterações: " + retorno);
                }

                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();

                //Imprimi a resposta
               System.out.println("editado com sucesso!");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
       }
       
       
       
       
       
       
       public Administrador getAdmistrador(int id){
           
            try {
               

                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/administrador/" + id + "/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                //Prepara para enviar dados para a requisição
                InputStream inputStream = connection.getInputStream();
                
                //Pega o que foi retornado pelo web service
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String linha;
                StringBuffer buffer = new StringBuffer();
                while((linha = reader.readLine()) != null) {
                    buffer.append(linha);
                }

                String str = buffer.toString();
                //System.out.println("String object do buffer: "+str);
                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();

               // System.out.println(str);
                
                Administrador admin = new Gson().fromJson(str, Administrador.class);
                return admin;
                //Imprimi a resposta
                //System.out.println("Reposta do servidor na htppService: " + buffer.toString());

              //  String retornado = gson.toJson(str);

              //  passageiroRetorno = gson.fromJson(str, Passageiro.class);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
       
       return null;
       
       }
       
       
       
       public Motorista getMotorista(int id){
           
            try {
               

                URL url = new URL("http://b8439639.ngrok.io/MoveMe/rest/motorista/" + id + "/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                //Prepara para enviar dados para a requisição
                InputStream inputStream = connection.getInputStream();
                
                //Pega o que foi retornado pelo web service
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String linha;
                StringBuffer buffer = new StringBuffer();
                while((linha = reader.readLine()) != null) {
                    buffer.append(linha);
                }

                String str = buffer.toString();
                //System.out.println("String object do buffer: "+str);
                //Fecha a conexão, deve-se fechar sempre após pegar a resposta
                connection.disconnect();

               // System.out.println(str);
                
                Motorista motorista = new Gson().fromJson(str, Motorista.class);
                return motorista;
                //Imprimi a resposta
                //System.out.println("Reposta do servidor na htppService: " + buffer.toString());

              //  String retornado = gson.toJson(str);

              //  passageiroRetorno = gson.fromJson(str, Passageiro.class);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
       
       return null;
       
       }
       
       
       
       public List<Motorista> listaEspera () throws Exception{
       
           List<Motorista> lista = motoristaGetAll();
           
           List<Motorista> listaEspera = new ArrayList<>();
           
           for (int i = 0; i < lista.size(); i++) {
               
               if(lista.get(i).getStatus() == 1){
               
                   listaEspera.add(lista.get(i));
               
               }
               
           }
           
       return listaEspera;
       }
       
       
       public List<Motorista> listaMotoristaRegular() throws Exception{
       
           List<Motorista> lista = motoristaGetAll();
           
           List<Motorista> listaMotoristaRegular = new ArrayList<>();
           
           for (int i = 0; i < lista.size(); i++) {
               
               if(lista.get(i).getStatus() == 0){
               
                   listaMotoristaRegular.add(lista.get(i));
               
               }
               
           }
           
       return listaMotoristaRegular;
       }
}
