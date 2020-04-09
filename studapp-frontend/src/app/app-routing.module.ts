import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentDetailComponent } from './components/student-detail/student-detail.component';
import { StudentsComponent } from './components/students/students.component';
import { StudijComponent} from './components/studij/studij.component';

const routes: Routes = [
  { path: '', redirectTo: '/students', pathMatch: 'full' },
  { path:'students', component: StudentsComponent },
  { path: 'student-detail/:jmbag', component: StudentDetailComponent},
  { path: 'studij', component: StudijComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
