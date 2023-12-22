import { profiles } from "../util/fake";

export function ProfileTable(){
    let items = profiles;
    return (<div>
        
        <table className='table'>
            <thead>
                <tr>
                    <th>Sn</th><th>pic</th><th>Name</th><th>Email</th><th>State</th><th>city</th>
                </tr>
            </thead>
            <tbody>
                {items.map((value,index)=><tr key = {index}>
                    <td>{index+1}</td>
                    <td><img src={value.imageUrl} className="profile-pic"/></td>
                    <td>{value.name}</td>
                    <td>{value.email}</td>
                    <td>{value.address.state}</td>
                    <td>{value.address.city}</td>


                </tr>)
                }
            </tbody>
             
        </table>
        
        </div>  );


}




export function Profile(props) {
    let prof = props.prof;
    return (<div>
        <div className="card" style={{width: '18rem'}}>
            <img src={prof.imageUrl} className="card-img-top" />
            <div className="card-body">
                <h5 className="card-title">Name: {prof.name}</h5>
                <p>Email: {prof.email}</p>
                <p>Occupation: {prof.occupation}</p>
                <p>Location: {prof.address?.city}, {prof.address?.state}</p>
            </div>
        </div>
    </div>)
}