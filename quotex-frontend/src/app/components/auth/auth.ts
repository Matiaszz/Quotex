import { Component } from '@angular/core';
import { Logo } from '../ui/logo/logo';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

type RegisterForm = {
  username: string,
  email: string,
  password: string,
  confirmPassword: string
}

type LoginForm = {
  email: string,
  password: string
}

@Component({
  selector: 'app-auth',
  imports: [Logo, FormsModule, CommonModule],
  templateUrl: './auth.html',
  styleUrl: './auth.scss',
})
export class Auth {
  showModal = false;
  modalType: 'info' | 'error' | 'warn' | 'delete' | 'success' = 'info';
  modalTitle = '';
  modalMessage = '';
  modalShowCancel = false;
  passwordsDoNotMatch: boolean = false;
  isLogin = false;

  register(values: RegisterForm){
      this.passwordsDoNotMatch = false;
    
      if (!values.username || !values.email || !values.password || !values.confirmPassword) {
        this.openModal('error', 'Erro', 'Todos os campos são obrigatórios.');
        return;
      }

      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      if (!emailPattern.test(values.email)) {
        this.openModal('error', 'Erro', 'E-mail inválido.');
        return;
      }

      if (values.password.length < 6) {
        this.openModal('error', 'Erro', 'Senha deve ter pelo menos 6 caracteres.');
        return;
      }

      if (values.password !== values.confirmPassword) {
        this.passwordsDoNotMatch = true;
        this.openModal('error', 'Erro', 'As senhas não conferem.');
        return;
      }
      
      this.openModal('success', 'Sucesso', 'Cadastro realizado com sucesso!');
  }

  login(values: LoginForm) {
  if (!values.email || !values.password) {
    this.openModal('error', 'Erro', 'Todos os campos são obrigatórios.');
    return;
  }

  const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailPattern.test(values.email)) {
    this.openModal('error', 'Erro', 'E-mail inválido.');
    return;
  }

  if (values.password.length < 6) {
    this.openModal('error', 'Erro', 'Senha deve ter pelo menos 6 caracteres.');
    return;
  }

  this.openModal('success', 'Bem-vindo!', 'Login realizado com sucesso!');
}

  onSubmit(values: RegisterForm | LoginForm) {
    if (!this.isLogin){
      this.register(values as RegisterForm);
    } else{
      this.login(values as LoginForm);
    }
    
}

  onModalOk() {
  this.showModal = false;
}

  onModalCancel() {
    this.showModal = false;
  }

  openModal(type: 'error' | 'info' | 'warn' | 'delete' | 'success', title: string, message: string, showCancel = false) {
    this.modalType = type;
    this.modalTitle = title;
    this.modalMessage = message;
    this.modalShowCancel = showCancel;
    this.showModal = true;
  }

  switchLogin(){
    this.isLogin = !this.isLogin;
  }

}
