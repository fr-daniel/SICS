<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-container>
              <v-toolbar flat color="white">
                <CadastrarBeneficio></CadastrarBeneficio>
              </v-toolbar>
              <v-data-table
                :headers="headers"
                :items="beneficios"
                :search="search"
                hide-actions
                :pagination.sync="pagination"
                class="elevation-1"
              >
                <template v-slot:items="props">
                  <td>
                    <v-checkbox :input-value="props.selected" primary hide-details></v-checkbox>
                  </td>
                  <td class="justify-center">{{ props.item.id }}</td>
                  <td class="justify-center">{{ props.item.titulo }}</td>
                  <td class="justify-center">{{ props.item.informacoes }}</td>
                  <td class="justify-center">{{ props.item.valor }}</td>
                  <td class="justify-center">
                    <v-btn
                      class="ma-2"
                      tile
                      depressed
                      dark
                      icon
                      color="#192A3E"
                      small
                      :to="{name: 'EditarCargo'}"
                    >
                      <v-icon small>edit</v-icon>
                    </v-btn>
                    <v-btn
                        @click="abrirDialogExcluirBeneficio(props.item)"
                        class="ma-2"
                        tile
                        depressed
                        dark
                        icon
                        color="#F7685B"
                        small
                      >
                        <v-icon small>delete</v-icon>
                      </v-btn>
                  </td>
                </template>
              </v-data-table>
              <div class="text-xs-center pt-2">
                <v-pagination v-model="pagination.page" :length="pages"></v-pagination>
              </div>
            </v-container>
          </v-card>
        </v-flex>
      </v-layout>

      <v-snackbar :color="dCor" right top v-model="dSnackbar">{{ dMensagem }}</v-snackbar>

      <v-dialog max-width="290" v-model="dialog">
        <v-card>
          <v-card-title class="headline">Excluir Benefício</v-card-title>

          <v-card-text>Tem certeza que deseja excluir o benefício?</v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>

            <v-btn @click="dialog = false" color="silver darken-1" flat="flat">Não</v-btn>

            <v-btn @click="excluirBeneficio()" color="red darken-1" flat="flat">Sim</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>

    </v-container>
  </v-app>
</template>


<script>
import axios from "axios";
import CadastrarBeneficio from "../beneficio/CadastrarBeneficio";
import store from "@/store";

export default {
    props: {
    cor: {
      type: String,
      default: ""
    },
    snackbar: {
      type: Boolean,
      default: false
    },
    mensagem: {
      type: String,
      default: ""
    }
  },

  components: { CadastrarBeneficio },
  data() {
    return {
      dialog: false,
      right: null,
      expand: false,
      search: "",
      pagination: {},
      selected: [],
      headers: [
        {
          text: "",
          align: "left",
          sortable: false,
          value: "selecionarBeneficio"
        },
        {
          text: "ID",
          align: "left",
          sortable: true,
          value: "id"
        },
        {
          text: "Título",
          align: "left",
          sortable: false,
          value: "titulo"
        },
        {
          text: "Informações",
          align: "left",
          sortable: false,
          value: "informacoes"
        },
        {
          text: "Valor",
          align: "left",
          sortable: false,
          value: "valor"
        },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      beneficios: [],
      dSnackbar: false,
      dMensagem: "",
      dCor: ""
    };
  },
  created: function() {
    this.initialize();
  },
  methods: {
    initialize() {
      axios.get("beneficio/listar").then(res => {
        this.beneficios = res.data;
      });
    },

    excluirBeneficio() {
      axios
        .delete("/beneficio/" + this.beneficioDelete.id)
        .then(() => {
          this.beneficios.splice(
            this.beneficios.indexOf(this.beneficioDelete),
            1
          );
          this.beneficioDelete = null;

          this.dSnackbar = true;
          this.dMensagem = "Exame excluído com sucesso";
          this.dCor = "success";
        })
        .catch(error => {
          this.dSnackbar = true;
          this.dMensagem = "Ocorreu um erro ao excluir o treinamento!";
          this.dCor = "error";
        });

      this.dialog = false;
    },

    abrirDialogExcluirBeneficio(beneficio) {
      this.beneficioDelete = beneficio;
      this.dialog = true;
    },
    logout() {
      this.$router.push("/logout");
    }
  },
  computed: {
    pages() {
      if (
        this.pagination.rowsPerPage == null ||
        this.pagination.totalItems == null
      )
        return 0;

      return Math.ceil(
        this.pagination.totalItems / this.pagination.rowsPerPage
      );
    }
  }
};
</script>

<style lang="css" scoped>
</style>