package br.com.inf.vacinado.DAO;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.com.inf.vacinado.Model.Usuario;

public class UsuarioDAO {

    //Variaveis para realizar a autenticacao
    static private FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
    static private FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();

    static private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    static private String mUserId = mFirebaseUser.getUid();
    private DatabaseReference ref = mDatabase.child("users");
    private Usuario usuarioG;

    public static void persistirUsuario(Usuario usuario) {
        //Realizando a persistencia offline
        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("cadastro");
        referencia.keepSynced(true);

        String id = mDatabase.child("users").child(mUserId).child("cadastro").child("id").push().getKey();
        usuario.setId(id);
        mDatabase.child("users").child(mUserId).child("cadastro").child(id).setValue(usuario);
        mDatabase.keepSynced(true);
    }

    public Usuario getUserById(FirebaseAuth.AuthStateListener mAuthListener) {
        mFirebaseAuth.addAuthStateListener(mAuthListener);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot vacSnapshot : dataSnapshot.getChildren()) {
                    Usuario usuario = vacSnapshot.getValue(Usuario.class);
                    if (usuario.getId() == mUserId) {
                        usuarioG = usuario;
                        Log.e("Entrou", "aki");
                        break;
                    } else{
                        Log.e("oie", "oie");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return usuarioG;
    }
}
