import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BlogModel} from '../../model/blog-model';
import {ApiConfig} from '../../api-config';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BlogRepositoryService {

  constructor(private httpClient: HttpClient) {
  }

  public addBlog(employeeId: number, blog: BlogModel): Observable<BlogModel> {
    return this.httpClient.post<BlogModel>(ApiConfig.BlogAPI, JSON.stringify(blog));
  }

  public getBlog(employeeId: number): Observable<BlogModel> {
    return this.httpClient.get<BlogModel>(ApiConfig.BlogAPI + employeeId);
  }
}
