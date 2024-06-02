package charada_java.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import charada_java.models.Charada;
import charada_java.models.Resposta;
import validador.CharadaValidador;

@WebServlet("/charadas")
public class CharadasServlet extends HttpServlet{
	private int respostasCorretas = 0;
	private int respostasErradas = 0;
	private static final long serialVersionUID = 1L;
	ArrayList<Charada> charadas = PrepararCharadas();
	private CharadaValidador validador = new CharadaValidador();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int numeroCharada = 0;
		
		if (req.getAttribute("metodo") != null) {
			numeroCharada = Integer.parseInt(req.getAttribute("numero-post").toString());
			
			if (numeroCharada == 5) {				
				req.setAttribute("respostas-corretas", respostasCorretas);
				req.setAttribute("respostas-erradas", respostasErradas);
				
				RequestDispatcher rdResultado = req.getRequestDispatcher("/views/resultado.jsp");
				rdResultado.forward(req, resp);
			}
			else {
				req.setAttribute("charada", charadas.get(numeroCharada));
				req.setAttribute("numero", numeroCharada);
				
				RequestDispatcher rd = req.getRequestDispatcher("/views/charadas.jsp");		
				rd.forward(req, resp);
			}
		}
		else {
			respostasCorretas = 0;
			respostasErradas = 0;
			
			req.setAttribute("charada", charadas.get(numeroCharada));
			req.setAttribute("numero", numeroCharada);
			
			RequestDispatcher rd = req.getRequestDispatcher("/views/charadas.jsp");		
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		if (req.getParameterMap().containsKey("metodo") && req.getParameter("metodo").equals("email")) {
			EnviarEmail(req.getParameter("email"), 
					req.getParameter("respostas-corretas").toString(), 
					req.getParameter("respostas-erradas").toString());
			
			resp.sendRedirect("charadas");
		} else {
			String resposta = req.getParameter("resposta-opcao");
			int numero = Integer.parseInt(req.getParameter("numero-charada"));
			
			if (validador.respostaValida(charadas.get(numero), resposta)) {
				respostasCorretas += 1;
			} else {
				respostasErradas += 1;
			}
			
			numero += 1;
			
			req.setAttribute("numero-post", numero);	
			req.setAttribute("metodo", "doPost");
			
			doGet(req, resp);	
		}
		
		
	}
	
	private ArrayList<Charada> PrepararCharadas() {
		ArrayList<Charada> charadas = new ArrayList<Charada>();
		
		Charada charada1 = new Charada();
		charada1.setTexto("01 - O que é, o que é? Tem o pai cantor, a mãe desdentada e o filho amarelo.");
		charada1.setRespostaCorreta("2");
		
		ArrayList<Resposta> respostas1 = new ArrayList<Resposta>();
		respostas1.add(new Resposta("1","Galo"));
		respostas1.add(new Resposta("2","Galinha"));
		respostas1.add(new Resposta("3","Ovo"));
		charada1.setRespostas(respostas1);
		
		Charada charada2 = new Charada();
		charada2.setTexto("02 - O que é, o que é? Quem faz, não usa. Quem usa, não vê. Quem vê, não quer usar.");
		charada2.setRespostaCorreta("1");
		
		ArrayList<Resposta> respostas2 = new ArrayList<Resposta>();
		respostas2.add(new Resposta("1","O caixão"));
		respostas2.add(new Resposta("2","A lança"));
		respostas2.add(new Resposta("3","A arma"));
		charada2.setRespostas(respostas2);
		
		Charada charada3 = new Charada();
		charada3.setNumero(3);
		charada3.setTexto("03 - O que é, o que é? Tem cabeça e tem dente, não é bicho e nem é gente.");
		charada3.setRespostaCorreta("3");
		
		ArrayList<Resposta> respostas3 = new ArrayList<Resposta>();
		respostas3.add(new Resposta("1","A cebola"));
		respostas3.add(new Resposta("2","O alho-poró"));
		respostas3.add(new Resposta("3","O alho"));
		charada3.setRespostas(respostas3);
		
		Charada charada4 = new Charada();
		charada4.setTexto("04 - O que é, o que é? O 4 disse para o 40.");
		charada4.setRespostaCorreta("2");
		
		ArrayList<Resposta> respostas4 = new ArrayList<Resposta>();
		respostas4.add(new Resposta("1","É meu irmão"));
		respostas4.add(new Resposta("2","Passa a bola"));
		respostas4.add(new Resposta("3","Meu reflexo"));
		charada4.setRespostas(respostas4);
		
		Charada charada5 = new Charada();
		charada5.setNumero(5);
		charada5.setTexto("05 - O que é, o que é? Feito para andar e não anda.");
		charada5.setRespostaCorreta("1");
		
		ArrayList<Resposta> respostas5 = new ArrayList<Resposta>();
		respostas5.add(new Resposta("1","A rua"));
		respostas5.add(new Resposta("2","A perna"));
		respostas5.add(new Resposta("3","O carro"));
		charada5.setRespostas(respostas5);
		
		charadas.add(charada1);
		charadas.add(charada2);
		charadas.add(charada3);
		charadas.add(charada4);
		charadas.add(charada5);
	
		return charadas;
	}

	private void EnviarEmail(String email, String respostasCertas, String respostasErradas) {
		System.out.println("Preparando Email..");
		
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	    
	    String meuEmail = "";
	    String minhaSenha = "";
	    
	    Session session = Session.getDefaultInstance(props,
	      new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication()
	           {
	        	   return new PasswordAuthentication(meuEmail, minhaSenha);
	           }
	      });

	    /** Ativa Debug para sessão */
	    session.setDebug(true);
	    
	    try {
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(meuEmail));
	        //Remetente
	        Address[] toUser = InternetAddress //Destinatário(s)
	                   .parse(email);

	        message.setRecipients(Message.RecipientType.TO, toUser);
	        message.setSubject("Resultado Charadas Java");//Assunto
	        message.setText("Respostas Certas: " + respostasCertas + " | Respostas Erradas: " + respostasErradas);
	        /**Método para enviar a mensagem criada*/
	        Transport.send(message);
	        
	        System.out.println("E-mail Enviado.");

	       } catch (MessagingException e) {
	          throw new RuntimeException(e);
	      }
	}
}
