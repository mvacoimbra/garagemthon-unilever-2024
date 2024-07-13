import React from 'react'

export default function Track() {
  return (
    <section className="w-full h-screen p-4 lg:p-8  bg-neutral-200 flex flex-col gap-20">
      <div className="text-4xl font-semibold flex flex-row gap-4">
        <h1>Rastreio</h1>
        <i className="fa-solid fa-satellite-dish" />
      </div>
      <div className="w-full h-full flex flex-col gap-10 justify-center items-center">
        <div className="flex flex-col justify-center gap-4 items-start w-1/2">
          <h2 className="font-semibold">
            Insira o código do pedido para rastreio:
          </h2>
          <label className="input input-bordered flex items-center gap-2 w-full">
            <input
              readOnly
              type="text"
              className="grow"
              placeholder="Search"
              value={'0005'}
            />
            <svg
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 16 16"
              fill="currentColor"
              className="h-4 w-4 opacity-70"
            >
              <path
                fillRule="evenodd"
                d="M9.965 11.026a5 5 0 1 1 1.06-1.06l2.755 2.754a.75.75 0 1 1-1.06 1.06l-2.755-2.754ZM10.5 7a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0Z"
                clipRule="evenodd"
              />
            </svg>
          </label>
        </div>
        <ul className="steps steps-vertical lg:steps-horizontal gap-4">
          <li className="step step-primary">Aprovação</li>
          <li className="step step-primary">Separação</li>
          <li className="step">Transporte</li>
          <li className="step">Entrega</li>
        </ul>
        <div className="card bg-transparent border-primary border-2 shadow-xl">
          <div className="card-body">
            <h2 className="card-title flex flex-col">Info</h2>
            <span>Em separação</span>
            <span>Centro de distribuição xxxxx</span>
            <span>última atualização: 24/06/2024</span>
          </div>
        </div>
      </div>
    </section>
  )
}
