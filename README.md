# nps
Nabucco's Pet Service

Este projeto permite a leitura de arquivos ".log" em um padrão específico "url", "timestamp+userId"+"uuid"+"regionCode" separados por espaço
em branco, ele deve ser enviado via GET para a api processar as informações que serão recuperadas através de um método POST.

**Características**
<br/>
NPS fora desenvolvido utilizando a linguagem Java. Como a ideia não era utilizar frameworks para a construção da api (como Springboot),
foi utilizada, neste caso, a biblioteca Jersey 2.28 para poder construir os serviços Rest (além das próprias bibliotecas internas do Java.
Quanto à confiabilidade e qualidade, o projeto fora desenvolvido sob a metodologia de TDD e outros aspectos importantes, os quais valem
mencionar foram:
<br/>
- Clean Code: Focando nos conceitos de SOLID para garantir um bom "clean code", princípios como responsabilidade única, inversão de dependência com uso de abstrações, interfaces específicas e o princípio aberto-fechado foram muito utilizados ao longo do desenvolvimento;
- Simplicidade: Utilizando os conceitos mencionados no item anterior, todo o código acabou ficando simples e bem legível. Vale ressaltar também a ausência de condicionais graças ao emprego de SOLID e os recursos proporcionados a partir do Java 8;
- Lógica: Toda a lógica realmente de valor encontra-se na camada Service onde todos os seguimentos são reconhecidos, separados conforme seus sua disposição na linha lida separados por espaçamento e, a partir daí, contabilizados os cálculos necessários para geração de um resumo em JSON contendo as métricas esperadas.
- Separação de Conceitos: Este quesito foi levado muito em conta, visto que, pelo frequente uso de interfaces,  abstrações e heranças bem definidas, quaisquer alterações ou novos requisitos implicantes a determinada característica do projeto (Ex: as classes DataRow, FileStream,  Metric, Analytics, Converter, etc.), 
bastaria apenas a criação de uma nova classe com novas regras implementando/extendendo suas respectivas interfaces/abstrações/pais.
- Escalabilidade e Perfomance: Novamente, ressalto aqui que o uso de SOLID fora de suma importância para este quesito, e, como mencionado, a ausência de condicionais é um bom exemplo a ser implicado na perfomance do projeto, pois a perfomance se restringe apenas ao número de dados/arquivos a serem lidos e processados, já que o código ficou bem simples e sem ausência de laços com mais de uma dimensão.
<br/>

**Funcionamento da API**
<br/>
- _localhost:8080/nps/restapi/laaa/health_: Não é necessário parâmetro, apenas executar a requisição para saber o estado do servidor;
- _localhost:8080/nps/restapi/laar/ingest_: Necessário que o nome do parâmetro seja "file" e que seu valor seja um arquivo ".log" selecionado no computador;
- _localhost:8080/nps/restapi/laa/metrics_: Não possui parâmetros, apenas executar a requisição para coleta de métricas que retornará em JSON. Obs: É necessário que existam arquivos logs no servidor para serem processados. Para isso basta ter enviado um arquivo com os logs para que este seja processado

**Notas importantes**
- Existe uma pasta "logs" na raiz do projeto, mas ela apenas abriga um exemplo de arquivo ".log" utilizado para os testes e exemplificar a dispoição dos dados.
- Conforme são enviados os arquivos ".log" (com nomes diferentes), a aplicação processará todos quando "localhost:8080/nps/restapi/laa/metrics", logo após os arquivos são deletados.
- Qualidade: 99,5% de cobertura de testes;
- Dado que números de acessos a um site em escala mundial,algumas tipagens de dados foram escolhidas especificamente em algumas modelo:
  - O tipo Long para o número de acessos (já que um novo acesso é algo que frequentemente ocorrerá, valores exorbitantes não seriam raros);
  - O tipo String para demais campos inclusive ids de usuários e código de região, vistos que, embora sejam agrupados para o cálculo de métricas,
  tais valores não de fatos utilizados para cálculo em si.
  - O tipo LocalDateTime para conversão do timestamp oriundo dos arquivos.log foi algo muito importante para encontrar de forma mais simples e direta
  valores como dia , semana e ano.
<br/>

**Possíveis Melhorias**
- Durante o desenvolvimento por alguma razão, o local planejado para a construção do arquivo .log recebido via GET (que seria na própria raiz do projeto) estava retornando um caminho
não desejado, logo alternativa fora salvar o arquivo na pasta do usuário que está utilizando a máquina. Logo, é necessária permissão de escrita nesta pasta, caso contrário
a aplicação irá retornar um erro 500. Assim, é visto como possível melhoria a verificação quanto o local para armazenar o arquivo para que este possa ser processado.
- Acrescentar BDD para fortalecer melhor as regras e os testes, garantindo assim mais qualidade ao projeto.
