package startup.loga.client.view;

public enum FxmlView {
	SIGNUP{
		@Override
		String getTitle() {
			return "LoGA | Register";
		}

		@Override
		String getFxmlFile() {
			return "fxml/auth-signup.fxml";
		}

	},
	LOGIN{
		@Override
		String getTitle() {
			return "LoGA | Login";
		}
		
		@Override
		String getFxmlFile() {
			return "fxml/auth-signin.fxml";
		}
		
	},
	MAIN{
		@Override
		String getTitle() {
			return "LoGA | Accueil";
		}

		@Override
		String getFxmlFile() {
			return "fxml/main.fxml";
		}

	},
	ADMIN{
		@Override
		String getTitle() {
			return "LoGA | Administrateur";
		}

		@Override
		String getFxmlFile() {
			return "fxml/admin.fxml";
		}

	},
	DASHBOARD{
		@Override
		String getTitle() {
			return "LoGA | Tableau de bord";
		}

		@Override
		String getFxmlFile() {
			return "fxml/dashboard.fxml";
		}

	},
	HOME{
		@Override
		String getTitle() {
			return "LoGA | Tableau de bord";
		}

		@Override
		String getFxmlFile() {
			return "fxml/home.fxml";
		}
	},
	ATELIER{
		@Override
		String getTitle() {
			return "LoGA | Atelier";
		}

		@Override
		String getFxmlFile() {
			return "fxml/home-atelier.fxml";
		}
	},
	AGENDA{
		@Override
		String getTitle() {
			return "LoGA | Agenda";
		}

		@Override
		String getFxmlFile() {
			return "fxml/agenda.fxml";
		}
	},
	PROFILE{
		@Override
		String getTitle() {
			return "LoGA | Profile";
		}

		@Override
		String getFxmlFile() {
			return "fxml/profile.fxml";
		}
	},
	STOCK{
		@Override
		String getTitle() {
			return "LoGA | Stock";
		}

		@Override
		String getFxmlFile() {
			return "fxml/stock.fxml";
		}
	},
	TRESOR{
		@Override
		String getTitle() {
			return "LoGA | Trésor";
		}

		@Override
		String getFxmlFile() {
			return "fxml/tresor.fxml";
		}
	},
	SUPPORT{
		@Override
		String getTitle() {
			return "LoGA | A propos";
		}

		@Override
		String getFxmlFile() {
			return "fxml/support.fxml";
		}
	},
	FOURNITURE{
		@Override
		String getTitle() {
			return "LoGA | Atelier | Fourniture";
		}

		@Override
		String getFxmlFile() {
			return "fxml/fourniture.fxml";
		}
	},
	AUTOMOBILE{
		@Override
		String getTitle() {
			return "LoGA | Atelier | Automobile";
		}

		@Override
		String getFxmlFile() {
			return "fxml/automobile.fxml";
		}
	},
	CLIENT{
		@Override
		String getTitle() {
			return "LoGA | Atelier | Client";
		}

		@Override
		String getFxmlFile() {
			return "fxml/client.fxml";
		}
	},
	RECEPTION{
		@Override
		String getTitle() {
			return "LoGA | Atelier | Réception";
		}

		@Override
		String getFxmlFile() {
			return "fxml/reception.fxml";
		}
	},
	REPARATION{
		@Override
		String getTitle() {
			return "LoGA | Atelier | Réparation";
		}

		@Override
		String getFxmlFile() {
			return "fxml/reparation.fxml";
		}
	},
	DOSSIER{
		@Override
		String getTitle() {
			return "LoGA | Atelier | Dossier";
		}

		@Override
		String getFxmlFile() {
			return "fxml/dossier.fxml";
		}
	};

	abstract String getTitle();
	abstract String getFxmlFile();
}
