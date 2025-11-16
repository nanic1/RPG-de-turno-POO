RPG de Turnos — Projeto POO (Console)

Este projeto é um jogo simples de RPG baseado em turnos, desenvolvido para praticar Programação Orientada a Objetos em Java.
O jogo roda no console e envolve personagens, ataques, defesa e uso de habilidades básicas.

O foco principal é mostrar como organizar classes, herança, polimorfismo e encapsulamento dentro de um pequeno sistema de batalha.

Estrutura do Jogo

O jogo funciona em turnos: um personagem age, depois o outro responde. Cada entidade pode atacar, defender ou usar uma habilidade simples definida em seu tipo (como cura ou dano direto).

As classes principais são:

Entidade: base para qualquer ser que participa da batalha. Possui nome, vida, ataque e defesa.

Personagem: extensão de Entidade que representa o jogador. Pode atacar, defender e usar habilidades.

Mago (ou outras classes específicas): personagens com comportamento próprio de ataque e defesa.

Habilidade: representa ações especiais simples (como cura ou dano direto).

TipoHabilidade: define o tipo da habilidade (ATAQUE, CURA ou DEFESA).

Mecânica de Batalha

Cada ação do personagem segue regras básicas:

Atacar: causa dano no alvo usando o valor de ataque.

Defender: reduz parte do dano recebido no próximo ataque.

Usar habilidade: dependendo do tipo, pode causar dano, curar ou aumentar defesa temporariamente.

O jogo segue até que um dos personagens chegue a zero de vida.
  
