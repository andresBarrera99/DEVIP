import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { IonicModule } from '@ionic/angular'
import { HeaderComponent } from './header/header.component'
import { RouterModule } from '@angular/router';



@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    IonicModule.forRoot(),
  ],
  declarations:[HeaderComponent],
  exports:[HeaderComponent,],
})
export class AppComponentsModule { }
