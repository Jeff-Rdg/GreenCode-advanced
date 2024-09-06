# Projeto de Conservação Marinha

Este projeto tem como objetivo registrar dados sobre diferentes áreas de conservação marinha, monitorar a eficácia das ações de conservação e calcular um índice geral de eficiência, utilizando diferentes indicadores. A abordagem abrange dois tipos principais de conservação: `ReservaMarinha` e `AreaProtegidaMarinha`, com um método comum para calcular a eficiência dessas ações.

## Estrutura do Projeto

### Classes

1. **`MarineConservation` (Abstração)**
    - Atributos:
        - `id`: Identificador único da área de conservação.
        - `name`: Nome da área de conservação.
        - `environmentalType`: Tipo de ambiente marinho presente.
        - `protectedArea`: Área protegida (em Km²).
        - `hasMonitoringProgram`: Indica se há um programa de monitoramento ativo.
      - **Indicadores de Conservação:**
      - `qualityWater`: Qualidade da água.
      - `coralCover`: Cobertura de coral.
      - `populationSpeciesExtinction`: População de espécies em extinção.
      - `biodiversity`: Índice de biodiversidade.
      - `protectedAreaIndex`: Índice da área protegida.
      - `monitoringLevel`: Nível de monitoramento.
      - `creationDate`: Data de criação da área protegida.
    - Método:
        - `calculateEfficiency()`: Método para calcular a eficiência da conservação usando uma métrica geral (detalhado abaixo).

2. **`MarineReservation`**
    - Herda de `MarineConservation`.
    - Atributos adicionais:
        - `reservationType`: Tipo específico de reserva (exemplos abaixo).
    - Exemplo de tipos de reserva marinha:
        - **Reserva Biológica Marinha**
        - **Parque Nacional Marinho**
        - **Reserva Extrativista Marinha**

3. **`ProtectedMarineArea`**
    - Herda de `MarineConservation`.
    - Não possui atributos adicionais específicos.

4. **`EspecieEmExtincao`**
    - Atributos:
        - `nomeCientifico`: Nome científico da espécie.
        - `nomePopular`: Nome popular da espécie.


## Indicadores de Conservação

O cálculo da eficiência das áreas de conservação é baseado em uma métrica composta de seis indicadores principais. Cada indicador é normalizado em uma escala de 0 a 100 para facilitar o cálculo e a comparação.

### Indicadores Utilizados:

1. **Qualidade da Água (QA)**
    - Escala: 0 a 100 (100 representa a melhor qualidade da água possível).
    - Peso no cálculo: 25%

2. **Cobertura de Coral (CC)**
    - Escala: 0 a 100 (100 representa a maior cobertura de coral possível).
    - Peso no cálculo: 20%

3. **População de Espécies em Extinção (PE)**
    - Escala: 0 a 100 (100 representa a população ideal ou crescimento positivo de espécies ameaçadas).
    - Peso no cálculo: 20%

4. **Biodiversidade (BI)**
    - Escala: 0 a 100 (100 representa a maior biodiversidade possível).
    - Peso no cálculo: 15%

5. **Área Protegida (AP)**
    - Escala: 0 a 100 (100 representa a maior área protegida possível).
    - Peso no cálculo: 10%

6. **Nível de Monitoramento (NM)**
    - Escala: 0 a 100 (100 representa o nível máximo de monitoramento).
    - Peso no cálculo: 10%

## Cálculo da Eficiência (IECM)

A eficiência da conservação marinha é calculada com base no **Índice de Eficiência de Conservação Marinha (IECM)**. O IECM é uma métrica composta que combina os seis indicadores mencionados anteriormente.

### Fórmula do Cálculo:

```text
IECM = (0.25 × QA) + (0.20 × CC) + (0.20 × PE) + (0.15 × BI) + (0.10 × AP) + (0.10 × NM)