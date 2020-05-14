package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import objetos.Categ;
import objetos.Compra;
import objetos.PessoaFisica;
import objetos.PessoaJuridica;
import objetos.Produto;
import objetos.Usuario;
import objetos.Venda;

public class Programa {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int id, qtde_estoque, escolha, k, menuopcao, opcao, i, j,data = 0,ctrl=0;
		String cnpj;
		String senha=null,senha2=null;
		String celular;
		String login=null,login2=null, nome, id_categ, email, cpf, continuar;
		double precovenda,precompra,total,desconto;
		boolean achou;

		List<Usuario> lista = new ArrayList<Usuario>();
		List<PessoaFisica> listaPessoaFisica = new ArrayList<PessoaFisica>();
		List<Categ> listaCategoria = new ArrayList<Categ>();
		List<Produto> listaProduto = new ArrayList<Produto>();
		List<Compra> listaCompra= new ArrayList<Compra>();
		List<Venda> listaVenda= new ArrayList<Venda>();
		List<PessoaJuridica> listaPessoaJuridica=new ArrayList<PessoaJuridica>();
		i=0;
	c:	do {
			try {
		System.out.println("nenhum usuario encontrado, iniciando criação de usuario...");
		System.out.println("informe seu login:");
		login=input.next();
		System.out.println("informe sua senha:");
		senha=input.next();
		}catch(Exception e) {
			System.out.println("Opção inválida.");
			continuar=input.next();
			continue c;
		}
		}while(i!=0);
		
	d:	do {
			try {
			System.out.println("O que deseja fazer:\n1:sair do programa\n2:fazer login");
			i = input.nextInt();
			if (i != 1 && i != 2) {
				System.out.println("comando invalido tente novamente");
			}
			}
			catch(Exception e){
				System.out.println("Opção inválida.");
				continuar=input.next();
				continue d;
			}
		} while (i != 1 && i != 2);
		if(i==1) {
			ctrl++;
		}
		else if(i==2) {
			b: 	do {
				try {
					System.out.println("informe login:");
					login2 = input.next();
					System.out.println("informe senha:");
					senha2 = input.next();
					if (!(login2.equals(login) && senha.equals(senha2))) {
						System.out.println("login ou senha incorretas");
						System.out.println("deseja sair do programa?(1 para sim,qualquer outra coisa para não)");
						j=input.nextInt();
						if(j==1) {
							ctrl++;
							break;
						}
					}
				} catch (Exception e) {
					System.out.println("Opção inválida.");
					continuar=input.next();
					continue b;
				}
				} while (!(login.equals(login2) && senha.equals(senha2)));
			}
		a: while (ctrl==0) {
			try {
				Menu();

				System.out.println("\nFavor escolher o que deseja:");
				menuopcao = input.nextInt();
				Usuario usuario = null;
				switch (menuopcao) {
				case 1:
					System.out.println(
							"Cadastro de Pessoas:\n1 - Cadastrar Usuario\n2 - Listar Usuario\n3 - Alterar usuario\n");
					opcao = input.nextInt();
					if (opcao == 1) {
						System.out.print("Favor digite seu CPF para Cadastro:");
						cpf = input.next();
						for (i = 0; i < listaPessoaFisica.size(); i++) {
							if (listaPessoaFisica.get(i).getCpf().equals(cpf)) {
								System.out.println("não pode haver 2 cpfs iguais");
								continue a;
							}
						}
						System.out.print("Favor digite seu Nome:");
						nome = input.next();
						System.out.print("Favor digite seu E-mail: ");
						email = input.next();
						System.out.println("Favor digite seu numero do Celular: ");
						celular = input.next();
						PessoaFisica pessoafisicausuario = new PessoaFisica(nome, email, celular, cpf);

						listaPessoaFisica.add(pessoafisicausuario);
						break;
					} else if (opcao == 2) {
						for (PessoaFisica p : listaPessoaFisica) {
							System.out.println(p);
						}
						break;
					} else if (opcao == 3) {
						System.out.println("qual pessoa deseja alterar?(informe o cpf)");
						cpf = input.next();
						achou = false;
						for (i = 0; i < listaPessoaFisica.size(); i++) {
							if (listaPessoaFisica.get(i).getCpf().equals(cpf)) {
								achou = true;
								do {
									System.out.println("o que deseja alterar?\n1-Cpf\n2-Email\n3-Celular\n4-Nome");
									j = input.nextInt();
									if (j < 1 || j > 4) {
										System.out.println("comando invalido, tente novamente");
									}
								} while (j < 1 || j > 4);

								switch (j) {
								case (1):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									cpf = input.next();
									for (k = 0; k < listaPessoaFisica.size(); k++) {
										if (listaPessoaFisica.get(k).getCpf().equals(cpf)) {
											System.out.println("não pode haver 2 cpfs iguais");
											continue a;
										}
									}
									listaPessoaFisica.get(i).setCpf(cpf);
									break;
								case (2):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									email = input.next();
									listaPessoaFisica.get(i).setEmail(email);
									break;
								case (3):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									celular = input.next();
									listaPessoaFisica.get(i).setCelular(celular);
									break;
								case (4):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									nome = input.next();
									listaPessoaFisica.get(i).setNome(nome);
									break;
								}
							}
						}
						if (achou == false) {
							System.out.println("pessoa não encontrada.");
						}
					}
					break;
				case 2:
					System.out.println(
							"Categoria do Produto\n 1 - Cadastrar Categoria:\n 2 - Listar Categoria\n 3 - Alterar Categoria\n");
					opcao = input.nextInt();
					if (opcao == 1) {
						System.out.println("Digite o NOME(id) da categoria:");
						id_categ = input.next();
						for (i = 0; i < listaCategoria.size(); i++) {
							if (listaCategoria.get(i).getId_categ().equals(id_categ)) {
								System.out.println("nao pode haver 2 ids iguais");
								continue a;
							}
						}
						Categ categ = new Categ(id_categ);
						listaCategoria.add(categ);
						break;
					} else if (opcao == 2) {
						for (Categ p : listaCategoria) {
							System.out.println(p);
						}
						break;
					} else if (opcao == 3) {
						System.out.println("qual categoria deseja alterar?(informe o ID)");
						id_categ = input.next();
						achou = false;
						for (i = 0; i < listaCategoria.size(); i++) {
							if (listaCategoria.get(i).getId_categ().equals(id_categ)) {
								achou = true;
								System.out.println("qual devera ser o novo valor para o ID?");
								id_categ = input.next();
								for (k = 0; k < listaCategoria.size(); k++) {
									if (listaCategoria.get(k).getId_categ().equals(id_categ)) {
										System.out.println("nao pode haver 2 ids iguais");
										continue a;
									}
								}
								listaCategoria.get(i).setId_categ(id_categ);
								break;
							}
						}
						if (achou == false) {
							System.out.println("pessoa não encontrada.");
						}
						break;
					}
				case 3:
					System.out.println(
							"Cadastro de Produto:\n1 - Cadastrar Produto:\n2 - Listar Produtos\n3 - Alterar Produtos");
					opcao = input.nextInt();
					if (opcao == 1) {
						System.out.println("Favor digite o ID do produto para Cadastro: ");
						id = input.nextInt();
						for (i = 0; i < listaProduto.size(); i++) {
							if (listaProduto.get(i).getId().equals(id)) {
								System.out.println("nao pode haver ids iguais");
								continue a;
							}
						}
						System.out.print("Favor digite o nome do produto para Cadastro: ");
						nome = input.next();
						System.out.println("Favor digite o preco da venda: ");
						precovenda = input.nextDouble();
						if(precovenda<0) {
							System.out.println("preco precisa ser positivo");
							continue a;
						}
						System.out.println("Favor digite a quantidade em estoque: ");
						qtde_estoque = input.nextInt();
						if(qtde_estoque<0) {
							System.out.println("quantia precisa ser pelo menos 0");
						}
						System.out.println("favor informe o preco de compra:");
						precompra=input.nextDouble();
						if(precompra<0) {
							System.out.println("preco precisa ser positivo");
							continue a;
						}
						if(precompra>precovenda) {
							System.out.println("compra nao pode ser maior que venda, produto nao sera cadastrado");
							continue a;
						}
						Produto produto = new Produto(id, nome, precovenda, qtde_estoque,precompra);
						listaProduto.add(produto);
						break;
					} else if (opcao == 2) {
						for (Produto p : listaProduto) {
							System.out.println(p);
						}
						break;
					} else if (opcao == 3) {
						System.out.println("qual produto deseja alterar?(informe o ID)");
						id = input.nextInt();
						achou = false;
						for (i = 0; i < listaProduto.size(); i++) {
							if (listaProduto.get(i).getId().equals(id)) {
								achou = true;
								do {
									System.out.println(
											"o que deseja alterar?\n1-ID\n2-Nome\n3-Preço de venda\n4-Qnt de estoque\n5-Preço de compra");
									j = input.nextInt();
									if (j < 1 || j > 5) {
										System.out.println("comando invalido, tente novamente");
									}
								} while (j < 1 || j > 5);

								switch (j) {
								case (1):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									id = input.nextInt();
									for (k = 0; k < listaProduto.size(); k++) {
										if (listaProduto.get(k).getId().equals(id)) {
											System.out.println("nao pode haver ids iguais");
											continue a;
										}
									}
									listaProduto.get(i).setId(id);
									break;
								case (2):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									nome = input.next();
									listaProduto.get(i).setNome(nome);
									break;
								case (3):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									precovenda = input.nextDouble();
									if(precovenda<0) {
										System.out.println("preco precisa ser positivo");
										continue a;
									}
									if(precovenda<listaProduto.get(i).getPrecompra()) {
										System.out.println("compra nao pode ser maior que venda");
										continue a;
									}
									listaProduto.get(i).setPrecovenda(precovenda);
									break;
								case (4):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									qtde_estoque = input.nextInt();
									listaProduto.get(i).setQtde_estoque(qtde_estoque);
								case(5):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									precompra=input.nextDouble();
									if(precompra<0) {
										System.out.println("preco precisa ser positivo");
										continue a;
									}
									if(precompra>listaProduto.get(i).getPrecovenda()) {
										System.out.println("compra nao pode ser maior que venda");
										continue a;
									}
									listaProduto.get(i).setPrecompra(precompra);
									break;
								}
							}
						}
						if (achou == false) {
							System.out.println("pessoa não encontrada.");
						}
					}
					break;
				case 4:
					PessoaJuridica pessoajuridica = null;
					System.out.println("### Cadastro de Fornecedores ###\n");
					System.out.println("1 - Cadastrar\n2 - Listar Fornecedor\n3 - Alterar");
					opcao = input.nextInt();
					if (opcao == 1) {
						System.out.print("Digite seu CNPJ: ");
						cnpj = input.next();
						for (i = 0; i < listaPessoaJuridica.size(); i++) {
							if (listaPessoaJuridica.get(i).getCnpj().equals(cnpj)) {
								System.out.println("nao pode haver cnpjs iguais");
								continue a;
							}
						}
						System.out.print("Digite seu Nome: ");
						nome = input.next();
						System.out.print("Digite seu E-mail: ");
						email = input.next();
						System.out.print("Digite seu celular: ");
						celular = input.next();
						pessoajuridica = new PessoaJuridica(nome, email, celular, cnpj);
						listaPessoaJuridica.add(pessoajuridica);
						break;
					} else if (opcao == 2) {
						for (PessoaJuridica p : listaPessoaJuridica) {
							System.out.println(p);
						}
						break;
					}
					
					else if (opcao == 3) {
						System.out.println("qual fornecedor deseja alterar?(informe o cnpj)");
						cnpj = input.next();
						achou = false;
						for (i = 0; i < listaPessoaJuridica.size(); i++) {
							if (listaPessoaJuridica.get(i).getCnpj().equals(cnpj)) {
								achou = true;
								do {
									System.out.println("o que deseja alterar?\n1-Cnpj\n2-Email\n3-Celular\n4-Nome");
									j = input.nextInt();
									if (j < 1 || j > 4) {
										System.out.println("comando invalido, tente novamente");
									}
								} while (j < 1 || j > 4);

								switch (j) {
								case (1):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									cnpj = input.next();
									for (k = 0; k < listaPessoaJuridica.size(); k++) {
										if (listaPessoaJuridica.get(k).getCnpj().equals(cnpj)) {
											System.out.println("nao pode haver cnpjs iguais");
											continue a;
										}
									}
									
									listaPessoaJuridica.get(i).setCnpj(cnpj);
									break;
								case (2):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									email = input.next();
									listaPessoaJuridica.get(i).setEmail(email);
									break;
								case (3):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									celular = input.next();
									listaPessoaJuridica.get(i).setCelular(celular);
									break;
								case (4):
									System.out.println("qual devera ser o novo valor para aquele dado?");
									nome = input.next();
									listaPessoaJuridica.get(i).setNome(nome);
									break;
								}
							}
						}
						if (achou == false) {
							System.out.println("fornecedor não encontrado.");
							break;
						}
						break;
					}
				
				
				case 5:	
					System.out.println("Qual produto deseja comprar?(informe o id)");
					id=input.nextInt();
					achou = false;
					for (i = 0; i < listaProduto.size(); i++) {
						if (listaProduto.get(i).getId().equals(id)) {
							achou = true;
							System.out.println("digite o id da compra:");
							id=input.nextInt();
							for (i = 0; i < listaCompra.size(); i++) {
								if (listaCompra.get(i).getId().equals(id)) {
									System.out.println("não pode haver 2 id iguais");
									continue a;
								}
							}
							System.out.println("digite a data da compra:");
							data=input.nextInt();
							System.out.println("informe o total de itens comprados:");
							j=input.nextInt();
							total=listaProduto.get(i).getPrecompra()*j;
							System.out.println("foi gasto "+total+" reais");
							qtde_estoque=listaProduto.get(i).getQtde_estoque()+j;
							listaProduto.get(i).setQtde_estoque(qtde_estoque);
							Compra compra=new Compra(id,data,total);
							listaCompra.add(compra);
							}
					}
					if(achou==false) {
						System.out.println("produto nao encontrado");
					}
					break;
				case 6:
					System.out.println("Qual produto deseja vender?(informe o id)");
					id=input.nextInt();
					achou = false;
					for (i = 0; i < listaProduto.size(); i++) {
						if (listaProduto.get(i).getId().equals(id)) {
							achou=true;
							System.out.println("digite o id da venda:");
							id=input.nextInt();
							for (i = 0; i < listaVenda.size(); i++) {
								if (listaVenda.get(i).getId().equals(id)) {
									System.out.println("não pode haver 2 id iguais");
									continue a;
								}
							}
							System.out.println("digite a data da venda:");
							data=input.nextInt();
							System.out.println("informe o total de itens vendidos:");
							j=input.nextInt();
							if(j>listaProduto.get(i).getQtde_estoque()) {
								System.out.println("nao há essa quantia em estoque, a venda nao será efetuada");
								continue a;
							}
							System.out.println("deseja desconto?(digite 1 para sim, e qualquer outro numero para nao)");
							k=input.nextInt();
							if(k==1) {
								System.out.println("qual será o valor de desconto em porcentagem:");
								desconto=input.nextDouble();
								if(desconto>100) {
									System.out.println("desconto nao pode ser maior que 100");
									continue a;
								}
								total=(listaProduto.get(i).getPrecovenda()*j)*(1-(desconto/100));
								if((total/j)<listaProduto.get(i).getPrecompra()) {
									System.out.println("o total arrecadado deve ser maior que o valor de compra");
									continue a;
								}
								System.out.println("foram arrecadados "+total+" reais");
								qtde_estoque=listaProduto.get(i).getQtde_estoque()-j;
								listaProduto.get(i).setQtde_estoque(qtde_estoque);
								Venda venda=new Venda(id,data,total,desconto);
								listaVenda.add(venda);
								
							}
							else {
								total=listaProduto.get(i).getPrecovenda()*j;
								System.out.println("foram arrecadados "+total+" reais");
								qtde_estoque=listaProduto.get(i).getQtde_estoque()-j;
								listaProduto.get(i).setQtde_estoque(qtde_estoque);
								Venda venda=new Venda(id,data,total,(double)0);
								listaVenda.add(venda);
							}
						}
					}
					if(achou==false) {
						System.out.println("produto nao encontrado");
					}
					break;
					
				case 0:
					System.out.println("Programa encerrado");
					input.close();
					System.exit(0);
				default:
					System.out.println("comando invalido");

				}
			} catch (Exception e) {
				System.out.println("Opção Inválida!");
				continuar = input.next();
			}
		}
	}

	public static void Menu() {
		System.out.println("\n\tSEJA BEM VINDO AO CONTROLE DE ESTOQUE\n"
				+ "\t1 - Cadastrar Pessoas / Listar / Alterar\n " + "\t2 - Cadastrar Categoria / Listar / Alterar\n "
				+ "\t3 - Cadastrar Produtos / Listar / Alterar\n "
				+ "\t4 - Cadastrar Fornecedores / Listar / Alterar\n " + "\t5 - Compra\n " + "\t6 - Venda\n"
				+ "\t0 - sair\n");
	}
}