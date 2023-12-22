// this file talks to the real backend api's, since we already have Profile component
// we will create UserProfile as a prefix to work with all the backend
import axios from 'axios';
import { useState } from 'react';
import { Link, Route, Routes } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import {  useNavigate } from 'react-router-dom';
import { useEffect } from 'react';
let BASE_URL = 'http://localhost:8086/api/profiles';


//success component
export function UserProfileSuccess(){
    const navigate = useNavigate();
    let {id} = useParams();
    let [profile, setProfile] = useState([]);


    useEffect( () => {axios.get(BASE_URL + '/' + id)
    .then(r => setProfile(r.data))},[]);
    return(
         (<div>
            <div className="w-25">
                <h3>Hello {profile.name} </h3>
                <h3>Hello {profile.phone}</h3>
                <h3>Hello {profile.birthday}</h3>
            </div>
            <div>
                <Link to = 'dashboaard'>Dashboard</Link>
                <Link to = 'addContact'>Add Contact</Link>
                <Link to = 'listContacts'>Show All Contacts</Link>
                <Link to = 'editProfile'>Edit Profile</Link>
                <div>
                    <Routes>
                        <Route path='' element={<div>Dashboard component <p>Total contacts:{profile.contacts?.length}</p></div>} />
                        <Route path='dashboard'  element={<div>Dashboard component <p>Total contacts:{profile.contacts?.length}</p></div>} />
                        <Route path='addContacts' element={<div>Add Contact component</div>} />
                        <Route path='listContacts' element={<div>List Contact component</div>} />
                    </Routes>
                </div>
    
        
    
            </div>
        </div>)
    )
}

//login profile
export function UserProfileLogin(){
    let [id, setId] = useState('');
    let [error, setError] = useState('');
    let navigate = useNavigate();

    const handleSubmit = (e) =>{
        e.preventDefault();
        axios.get(BASE_URL+'/'+id)
        .then(response => {
            navigate('/success/'+id);
        })
        .catch(error =>{
            //console.log(error.error.error);
            setId('');
            setError(error.response.data.error)
        });
    }

    return(
        <div className='w-25'>
            <h2>User Login</h2>
            <form onSubmit={handleSubmit}>
                <label htmlFor="userID">Enter your ID : </label>
                <input type='text' id='userID' value={id}
                onChange={(e)=>{setId(e.target.value)}}/><br />
                <input type='submit' value='Login'></input>
                <div>
                    {error != '' ? <div className='text-danger'>{error}</div>:<div></div>}
                </div>
                <div>
                    <Link to='/register'>Create profile</Link>
                </div>
            </form>
        </div>
    )
}



//storing the profile in the backend
export function UserProfileRegistration(){
    let [name , setName] = useState("");
    let [id,setId] = useState(""); 
    let [password,setPassword] = useState("");
    let [phone,setPhone] = useState("");
    let [birthday,setBirthday] = useState("");
    let [message,setMessage] = useState("");//to show success message
    const handleSubmit = (e) =>{
        e.preventDefault();
        axios.post(BASE_URL+'/store',{"name":name,"password":password,"phone":phone,"birthday":birthday})
        .then(response => {
            setId(response.data.id);
            setMessage(`${response.data.id}`)
        })
        .catch(error => setMessage(`${error}`));

        setName("");
        setBirthday("");
        setPassword("");
        setPhone("");
        
        
    }
    
    const handleReset =(e) =>{
        e.preventDefault();
        setName("");
        setBirthday("");
        setPassword("");
        setPhone("");
    }

    

    return(
        <div className='w-25'>
            <h1>Register</h1>
            <form onSubmit={handleSubmit} onReset={handleReset}>
                <div>
                Name :
                <input type="text" value={name}  onChange={(e)=>{setName(e.target.value)}}/><
                    br />
                </div>
                <div>
                    password:
                    <input type="password" value={password}   onChange={(e)=>{setPassword(e.target.value)}}/>
                </div>
                <div>
                    Phone:
                    <input type="number" value={phone}  onChange={(e)=>{setPhone(e.target.value)}}/>
                </div>
                <div>
                    Birthday:
                    <input type="date" value={birthday}  onChange={(e)=>{setBirthday(e.target.value)}}/>
                </div>
                <div>
                    <button type="submit" value ='Register'>Sign Up</button>
                    <button type="reset" value='reset'>Reset</button>
                </div>
                <div>
                    {/* display the message if there is any */}
                    {id != '' ? <div className='text-success'>{message} </div>:<div>''</div>}
                </div>
            </form>
        </div>
    )
}



// Lists all the profiles in a table format
export function UserProfileList() {
    //state to store the profiles
    let [profiles, setProfiles] = useState([]);
    //handler that sends request to the backend
    let loadProfiles = (e) => {
        axios.get(BASE_URL)
        .then(response => setProfiles(response.data))
        .catch(error => console.log(error));
    };
    return (<div>
        <h2>List of profiles</h2> <hr />
        <button onClick = {loadProfiles} className = 'btn btn-secondary'>Load All Profiles</button>
        {/* <div className = 'row'>
            {
                profiles.map((item, index) => <p key = {index}> Id: {item.id}, Name: {item.name}, 
                    Birthday: {item.birthday}, No of contacts: {item.contacts.length}
                </p>)
            }
        </div> */}
        <h3>Displaying the same output using card, with dummy images</h3>
        <div className = 'row'>
            {
                profiles.map((item, index) => <div key = {index} className = 'col-4'>
                    <div className="card" style={{width: '15rem'}}>
                        <img src= 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMhuYcyWOfOrmXs7ItuvY2wnvJdNdid_euww&usqp=CAU' 
                            className="card-img-top" style={{height:'20vh'}} />
                        <div className="card-body">
                            <h5 className="card-title">Name: {item.name}</h5>
                            <p>Id: {item.id}</p>
                            <p>Phone: {item.phone}</p>
                            <p>Birthday: {item.birthday}</p>
                            <p>No. of contacts: {item.contacts.length}</p>
                        </div>
                    </div>
                </div>)
            }
        </div>
        </div>)
}