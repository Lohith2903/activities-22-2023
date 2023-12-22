import logo from './logo.svg';
import './App.css';
import { UserProfileList , UserProfileRegistration, UserProfileLogin, UserProfileSuccess} from './components/RealProfile';
import { Profile,ProfileTable } from './components/profile';
import { Comment } from './components/comment';
import { profiles } from './util/fake';
import { MyForm } from './components/user';
import { Link,Routes,Route } from 'react-router-dom';
function App() {
  
  return (
    <div className='container-fluid'>
      <h2 className='alert alert-primary'>Profile Management</h2>
      <div className='row'>
        <div className='col'>
          <Routes>
          <Route path="" element={<UserProfileLogin/>}/>
            <Route path="/register" element={<UserProfileRegistration />}/>
            <Route path="/login" element={<div>login under construction</div>}/>
            <Route path="/list" element={<UserProfileList/>}/>
            <Route path="/success/:id/*" element={<UserProfileSuccess/>}/>
            </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;
