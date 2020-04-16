import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentDetailComponent } from './components/student-detail/student-detail.component';
import { StudentsComponent } from './components/students/students.component';
import { StudijComponent} from './components/studij/studij.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { LecturerComponent } from './components/lecturer/lecturer.component';
import { LecturerDetailComponent } from './components/lecturer-detail/lecturer-detail.component';


const routes: Routes = [
  { path: '', redirectTo: '/welcome', pathMatch: 'full' },
  { path:'students', component: StudentsComponent },
  //{ path: 'student-detail', component: StudentDetailComponent},
  { path: 'student-detail/:jmbag', component: StudentDetailComponent},
  { path: 'studij', component: StudijComponent},
  { path: 'welcome', component: WelcomeComponent},
  { path: 'lecturers', component: LecturerComponent},
  { path: 'lecturer-detail/:id', component: LecturerDetailComponent}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
