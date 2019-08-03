import { Plano } from '../plano/plano';

export class Profissional {
  id: number;
  nome: string;
  cep: string;
  email: string;
  telefone: number;
  cpf: string;
  regiao: string;
  senha: string;
  plano: Plano;
}
