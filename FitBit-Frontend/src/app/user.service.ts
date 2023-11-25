import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable, catchError } from 'rxjs';
import { UserM } from './user-m';

@Injectable({
  providedIn: 'root'
})
export class UserService {
   private url = "http://localhost:8080/getAllUsers";
  constructor(private http:HttpClient) { }
  getApi():Observable<UserM[]>{
    return this.http.get<UserM[]>(`${this.url}`);
  }
  
  private apiUrl="http://localhost:8080/signInUser";
  addUser(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, user);
}

private deleteUserApi = 'http://localhost:8080/deleteUser';

deleteUser(id: number): Observable<object> {
  return this.http.delete(`${this.deleteUserApi}/${id}`).pipe(
    catchError((error: any) => {
      console.error('Error deleting user:', error);
      throw error; // rethrow the error to let the subscriber handle it
    })
  );
}


private updatePasswordUrl = 'http://localhost:8080/passwordUpdated';
updatePassword(uemail: string, newPassword: string, confirmPassword: string): Observable<any> {
  const body = { uemail, newPassword, confirmPassword };
  return this.http.post(this.updatePasswordUrl, body);
}


}
