import Chart from 'chart.js/auto';

function Dashboard(){

  const data = {
    "customers":10000,
    "automobiles":10000,
    "repairs":10000,
    "diagnosis":10000
  }

  const load = (e) =>{
    const ctx = document.getElementById('myChart');
    
    const myChart = new Chart(ctx, {
      type: 'line',
      data: {
        labels: [
          'Sunday',
          'Monday',
          'Tuesday',
          'Wednesday',
          'Thursday',
          'Friday',
          'Saturday'
        ],
        datasets: [{
          data: [
            15339,
            21345,
            18483,
            24003,
            23489,
            24092,
            12034
          ],
          lineTension: 0,
          backgroundColor: 'transparent',
          borderColor: '#007bff',
          borderWidth: 4,
          pointBackgroundColor: '#007bff'
        }]
      },
      options: {
        plugins: {
          legend: {
            display: false
          },
          tooltip: {
            boxPadding: 3
          }
        }
      }
    });
  }
    
    return(
      <div className="container-fluid">
        <div className="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
          <h1 className="h2">Tableau de bord</h1>
          <div className="btn-toolbar mb-2 mb-md-0">
            <div className="btn-group me-2">
              <button type="button" className="btn btn-sm btn-outline-secondary" onClick={load}>
                <img className="img-fluid" width="32" height="32" src="/assets/icon/ico-settings.PNG"/>
              </button>
            </div>
          </div>
        </div>
        <div className="container-fluid d-inline-flex flex-wrap flex-md-nowrap align-items-center justify-content-between">
          <button type="button" className="btn btn-sm btn-outline-warning object-fit-contain">
            <img className="img-fluid" width="48" height="48" src="/assets/img/client.png"/>
            <span className="badge text-bg-warning">{data.customers}</span>
          </button>
          <button type="button" className="btn btn-sm btn-outline-secondary">
            <img className="img-fluid" width="48" height="48" src="/assets/img/automobile.png"/>
            <span className="badge text-bg-secondary">{data.automobiles}</span>
          </button>
          <button type="button" className="btn btn-sm btn-outline-primary">
            <img className="img-fluid" width="48" height="48" src="/assets/img/reparation.png"/>
            <span className="badge text-bg-primary">{data.repairs}</span>
          </button>
        </div>
        <canvas className="my-4 w-100 h-50" id="myChart" width="900" height="380"></canvas>
      </div>
    );
}

export default Dashboard;