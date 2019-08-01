import { Plano } from '../plano/plano';

export class Profissional {
  id: number;
  nome: string;
  cep: number;
  email: string;
  telefone: number;
  cpf: number;
  regiao: string;
  senha: string;
  plano: Plano;
}
