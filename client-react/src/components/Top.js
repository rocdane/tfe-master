function Top() {
    const jump = () => {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    }

    return(    
        <div className="position-fixed bottom-0 end-0 mb-3 me-3">
            <a className="btn bg-primary text-white bg-opacity-25" id="top" onClick={jump}>
            <img 
                className="img-fluid"
                width="32"
                height="32"
                src="/assets/icon/arrow-up.png"
            />
            </a>
        </div>
    ); 
}

export default Top;